package baekjoon_online_judge.solved.q1003_피보나치함수;

import java.io.*;
import java.util.Arrays;

public class Main {
    private final Reader reader = new InputStreamReader(System.in);
    private final Writer writer = new OutputStreamWriter(System.out);
    private final BufferedReader bufferedReader = new BufferedReader(reader);
    private final BufferedWriter bufferedWriter = new BufferedWriter(writer);

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        try{
            int condition = 40;
            int[] referenceArray = new int[condition + 2];  //피보나치 수 저장해두는 배열 
            Arrays.fill(referenceArray, -1);
            StringBuilder sb = new StringBuilder();

            int count = Integer.parseInt(bufferedReader.readLine());
            int turn = 0;
            while(turn < count){
                solve(sb, referenceArray, bufferedReader.readLine());
                turn++;
            }
            bufferedWriter.write(sb.toString());
            bufferedWriter.flush();
            sb.setLength(0);
        } catch (IOException ignored){
        } finally {
            try {
                resourceClose();
            } catch (IOException ignored){
            }
        }
    }

    private void solve(StringBuilder sb, int[] array, String input) {
        int number = Integer.parseInt(input);
        int[] result = fibonacci(array, number);
        sb.append(result[0])
                .append(" ")
                .append(result[1])
                .append("\n");
    }

    //피보나치 구하기
    private int[] fibonacci(int[] record, int index) {
        if(index == 0){
            return new int[]{1, 0};
        }

        for (int i = 0; i <= index + 1; i++) {
            //전에 피보나치 구해두었다면 넘어가기
            if(record[i] != -1){
                continue;
            }
            if (i < 2) {
                record[i] = i;
                continue;
            }
            if(record[i] == -1){
                record[i] = record[i - 2] + record[i - 1];
            }
        }
        return new int[]{record[index - 1], record[index]};
    }

    //자원해제
    private void resourceClose() throws IOException {
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
        reader.close();
        writer.close();
    }
}