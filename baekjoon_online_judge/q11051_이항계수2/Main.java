package baekjoon_online_judge.q11051_이항계수2;

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
            /*
            특정 숫자의 나머지 구하기
            -> 큰 숫자는 거르도록 설정

             */

//            for(){
//
//            }
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            int multiOn = 1;
            for (int i = 0; i < k; i++) {
                multiOn *= (n-i);
                if(10000 < multiOn){

                }
            }
            /*

            103


            110 111 112 나머지만 가져오기 > 그래서...?

             */


            int multiUnder = 1;
            for (int i = 1; i <= k; i++) {
                multiUnder *= i;
            }
            int divide = 10007;
            return (multiOn / multiUnder) % divide;
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