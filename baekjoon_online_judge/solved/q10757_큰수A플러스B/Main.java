package baekjoon_online_judge.solved.q10757_큰수A플러스B;

import java.io.*;
import java.util.Arrays;

public class Main {
    private final Reader reader = new InputStreamReader(System.in);
    private final Writer writer = new OutputStreamWriter(System.out);
    private final BufferedReader bufferedReader = new BufferedReader(reader);
    private final BufferedWriter bufferedWriter = new BufferedWriter(writer);

    public static void main(String[] args) throws IOException {
        new Main().start();
    }

    private void start() {
        try {
            execute();
        } catch (IOException ignored){
        }
    }

    private void execute() throws IOException {
        try{
            String[] numbers = bufferedReader.readLine().split(" ");
            bufferedWriter.write(calculate(numbers));
            bufferedWriter.flush();
        } catch (IOException io){
            io.printStackTrace();
        } finally {
            try {
                resourceClose();
            } catch (IOException io){
                io.printStackTrace();
            }
        }
    }

    //연산
    private String calculate(String[] numbers) {
        String a = numbers[0];
        String b = numbers[1];
        int room = Math.max(a.length(), b.length());

        int[] intArrayA_reverse = getReverseIntArray(a, room);
        int[] intArrayB_reverse = getReverseIntArray(b, room);
        boolean up = sum(intArrayA_reverse, intArrayB_reverse);  //올림여부
        return getNumberString(intArrayA_reverse, up).toString();
    }

    //역순 int[] 생성
    private int[] getReverseIntArray(String s, int room){
        int[] result = new int[room];
        Arrays.fill(result, 0);
        int size = s.length();

        for (int i = 0; i < room; i++) {
            if (i < s.length()) {
                result[size - i - 1] = Integer.parseInt(s.substring(i, i + 1));
            }
        }
        return result;
    }

    //배열간 합
    private boolean sum(int[] a, int[] b){
        int convey = 0;     //올림수
        int sum;

        for (int i = 0; i < a.length; i++) {
            sum = a[i] + b[i] + convey;
            if(sum >= 10){
                sum = sum - 10;
                convey = 1;
            } else {
                convey = 0;
            }
            a[i] = sum;
        }
        return convey == 1;
    }

    //출력문자열 생성
    private StringBuilder getNumberString(int[] A, boolean up){
        StringBuilder sb = new StringBuilder();
        if (up){
            sb.append(1);
        }
        int i;
        for (i = A.length - 1; i >= 0; i--) {
            sb.append(A[i]);
        }
        return sb;
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