package baekjoon_online_judge.q192_소수구하기;

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

        //연산
        private void solve(StringBuilder sb, String[] input) {
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    sb.append(i).append("\n");
                }
            }
        }

        private boolean isPrime(int number){
            if(number == 1){
                return false;
            }
            int limit = number / 2;
            int i;
            for(i=2; i<=limit; i++){
                if(number % i == 0){
                    return false;
                }
            }
            return true;
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