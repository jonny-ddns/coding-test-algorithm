package baekjoon_online_judge.solved.q11050_이항계수1;

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
                String[] input = bufferedReader.readLine().trim().split(" ");
                bufferedWriter.write( Integer.toString(solve(input))  );
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
        private int solve(String[] input) {
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int multiOn = 1;
            for (int i = 0; i < k; i++) {
                multiOn *= (n-i);
            }

            int multiUnder = 1;
            for (int i = 1; i <= k; i++) {
                multiUnder *= i;
            }
            return multiOn / multiUnder;
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