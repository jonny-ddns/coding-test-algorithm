package baekjoon_online_judge.unsolved.q1003_피보나치함수;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        new Solution();
    }

    static class Solution {
        private Reader reader;
        private Writer writer;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;

        private Solution() {
            resourceOpen();
            execute();
        }

        //입출력
        private void execute() {
            try{
                StringBuilder sb = new StringBuilder();
                int count = Integer.parseInt(bufferedReader.readLine());
                int turn = 0;
                while(turn < count){
                    solve(sb, bufferedReader.readLine());
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

        //연산
        private void solve(StringBuilder sb, String input) {
            int number = Integer.parseInt(input);
            int[] record = new int[]{0, 0};
            fibonacci(record, number);
            sb.append(record[0])
                .append(" ")
                .append(record[1])
                .append("\n");
        }

        private int fibonacci(int[] record, int n) {
            if(n < 2){
                record[n] = record[n] + 1;
                return n;
            }
            int[] array = new int[n + 1];
            int turn = 0;
            while(turn < n+1){
                array[turn++] = -1;
            }

            if (array[n] != -1) {
                return array[n];
            }
            return fibonacci(record, n - 2) + fibonacci(record, n-1);
        }

        /*---------------------------------------------*/
        //자원할당
        private void resourceOpen(){
            reader = new InputStreamReader(System.in);
            writer = new OutputStreamWriter(System.out);
            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);
        }

        //자원해제
        private void resourceClose() throws IOException {
            if (reader != null)             reader.close();
            if (writer != null)             writer.close();
            if (bufferedReader != null)     bufferedReader.close();
            if (bufferedWriter != null)     bufferedWriter.close();
        }
    }
}