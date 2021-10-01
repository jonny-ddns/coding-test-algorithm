package baekjoon_online_judge.unsolved.q2231_분해합;

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
                String input = bufferedReader.readLine().trim();
                bufferedWriter.write( Integer.toString(solve(input)) );
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
        private int solve(String input) {
            int number = Integer.parseInt(input);
            int index = 0;
            for (int i = 0; i <= number; i++) {
                if(isConstructor(number, i)){
                    index = i;
                    break;
                }
            }
            if(index == number){
                index = 0;
            }
            return index;
        }

        private boolean isConstructor(int number, int candidate){
            int tmp = candidate;
            int sum = 0;
            int remain;
            while (0 < tmp) {
                remain = tmp % 10;
                sum += remain;
                tmp = tmp / 10;
            }
            int result = candidate + sum;
            return result == number;
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