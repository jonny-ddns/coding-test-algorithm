package baekjoon_online_judge.unsolved.q1929_�Ҽ����ϱ�;

import java.io.*;
import java.util.Arrays;

/*
M�̻�  N ������ �Ҽ��� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
ù° �ٿ� �ڿ��� M�� N�� �� ĭ�� ���̿� �ΰ� �־�����.
(1 �� M �� N �� 1,000,000) M�̻� N ������ �Ҽ��� �ϳ� �̻� �ִ� �Է¸� �־�����.
 */
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

        //�����
        private void execute() {
            try{
                StringBuilder sb = new StringBuilder();
                String[] input = bufferedReader.readLine().split(" ");
                solve(sb, input);
                bufferedWriter.write( sb.toString());
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
        private void solve(StringBuilder sb, String[] input) {
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            if(start == 1){
                start++;
            }

            boolean[] booleanArray = new boolean[end - start + 1];
            Arrays.fill(booleanArray, true);
            System.out.println("��� true ����");

            check2357(booleanArray, start);
            System.out.println("2357 ����");
            
            for (int i = 0; i < booleanArray.length; i++) {
                if(booleanArray[i]){
                    System.out.println(i + " - Ȯ���ؾ߰ڳ׿�");
                    isPrime(booleanArray, start, i);
                    checkRemain(booleanArray, start, end, i);
                }
            }
            System.out.println("�����佺 üũ");
            startCheck(sb, start);
            for (int i = 0; i <= end-start; i++) {
                if(booleanArray[i]){
                    sb.append(i + start).append("\n");
                }
            }
        }

        private void check2357 (boolean[] array, int start){
            int tmp;
            for (int i = 0; i < array.length; i++) {
                tmp = i + start;
                if(tmp % 2 == 0 || tmp % 3 == 0 || tmp % 5 == 0 || tmp % 7 == 0) {
                    array[i] = false;
                }
            }
        }

        private void isPrime(boolean[] booleans, int start, int index) {
            System.out.println("���� ���� = " + (start + index));
            int number = start + index;
            int limit = number / 2;
            int i;
            for (i = 2; i <= limit; i++) {
                if (number % i == 0) {
                    System.out.println(number + " -> �Ҽ��� �ƴմϴ�");
                    booleans[index] = false;
                    return;
                }
            }
        }

        private void checkRemain(boolean[] booleanArray, int start, int end, int i) {
            if (i < 4) {
                return;
            }
            int realNumber = start + i;
            int count = 1;
            int index;
            while ((index = realNumber * (++count)) <= end) {
                booleanArray[index - start] = false;
            }
        }

        private void startCheck(StringBuilder sb, int start){
            if(start <= 2){
                sb.append(2).append("\n");
            }
            if(start <= 3){
                sb.append(3).append("\n");
            }
            if(start <= 5){
                sb.append(5).append("\n");
            }
            if(start <= 7){
                sb.append(7).append("\n");
            }
        }

        /*---------------------------------------------*/
        //�ڿ��Ҵ�
        private void resourceOpen(){
            reader = new InputStreamReader(System.in);
            writer = new OutputStreamWriter(System.out);
            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);
        }

        //�ڿ�����
        private void resourceClose() throws IOException {
            if (reader != null)             reader.close();
            if (writer != null)             writer.close();
            if (bufferedReader != null)     bufferedReader.close();
            if (bufferedWriter != null)     bufferedWriter.close();
        }
    }
}