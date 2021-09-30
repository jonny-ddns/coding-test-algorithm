package baekjoon_online_judge.solved.q2935_소음;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        new Solution();
    }

    //중첩클래스
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
                String number1 = bufferedReader.readLine().trim();
                String calculate = bufferedReader.readLine().trim();
                String number2 = bufferedReader.readLine().trim();
                bufferedWriter.write( solve(number1, number2, calculate) );
                bufferedWriter.flush();
            } catch (IOException ignored){
            } finally {
                try {
                    resourceClose();
                } catch (IOException ignored){
                }
            }
        }

        //연산
        private String solve(String input1, String input2, String calculate){
            int spot1 = input1.length() - 1;
            int spot2 = input2.length() - 1;
            StringBuilder sb = new StringBuilder();

            //곱하기
            if(calculate.equals("*")){
                sb.append("1");
                for (int i = 0; i < spot1 + spot2; i++) {
                    sb.append("0");
                }
                return sb.toString();
            }

            //더하기
            if (spot1 == spot2) {
                sb.append("2");
                for (int i = 0; i < spot1; i++) {
                    sb.append("0");
                }
                return sb.toString();
            }

            if (spot1 < spot2) {
                int tmp = spot1;
                spot1 = spot2;
                spot2 = tmp;
            }

            sb.append("1");
            for (int i = 0; i < spot1 - spot2 - 1; i++) {
                sb.append("0");
            }
            sb.append("1");
            for (int i = 0; i < spot2; i++) {
                sb.append("0");
            }
            return sb.toString();
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