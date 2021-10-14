package baekjoon_online_judge.solved.q10757_ū��A�÷���B;

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

    //����
    private String calculate(String[] numbers) {
        String a = numbers[0];
        String b = numbers[1];
        int room = Math.max(a.length(), b.length());

        int[] intArrayA_reverse = getReverseIntArray(a, room);
        int[] intArrayB_reverse = getReverseIntArray(b, room);
        boolean up = sum(intArrayA_reverse, intArrayB_reverse);  //�ø�����
        return getNumberString(intArrayA_reverse, up).toString();
    }

    //���� int[] ����
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

    //�迭�� ��
    private boolean sum(int[] a, int[] b){
        int convey = 0;     //�ø���
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

    //��¹��ڿ� ����
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

    //�ڿ�����
    private void resourceClose() throws IOException {
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
        reader.close();
        writer.close();
    }
}