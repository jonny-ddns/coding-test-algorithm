package baekjoon_online_judge.unsolved.q10509_goodMorning;

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
                int count = Integer.parseInt(bufferedReader.readLine().trim());
                for (int i = 0; i < count; i++) {
                    solve(sb, bufferedReader.readLine());
                }
                bufferedWriter.write(sb.toString());
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
        private void solve(StringBuilder sb, String input) {
            int result = calculate(input);
            sb.append(result).append("\n");
        }

        /*
        123
        456
        789
        0
         */
        private int calculate(String number){
            number.split("");

            return 0;
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