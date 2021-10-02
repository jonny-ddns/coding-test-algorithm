package baekjoon_online_judge.q2581_�Ҽ�;

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

        //�����
        private void execute() {
            try{
                int M = Integer.parseInt(bufferedReader.readLine().trim());
                int N = Integer.parseInt(bufferedReader.readLine().trim());
                bufferedWriter.write( solve(M, N) );
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
        private String solve(int start, int end) {
            boolean[] checkResult = new boolean[end - start + 1];
            for (int i = start; i <= end; i++) {
                checkResult[i-start] = check(i);
            }

            int[] result = calculate(checkResult, start);
            if(result.length == 1){
                return "-1";
            }
            return result[0] + "\n" + result[1];
        }

        private int[] calculate(boolean[] checkResult, int start){
            int count = 0;
            int index = 0;
            int sum = 0;
            for (int i = checkResult.length - 1; i >= 0; i--) {
                if (checkResult[i]) {
                    index = i;
                    sum += i;
                    count++;
                }
            }
            if(count == 0){
                return new int[1];
            }
            return new int[]{start * count + sum, start + index};   //�Ҽ�����, �ּڰ�
        }

        //�Ҽ�����
        private boolean check(int number){
            for (int i = 2; i < number / 2 + 1; i++) {
                if(number % i == 0){
                    return false;
                }
            }
            return number != 1;
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