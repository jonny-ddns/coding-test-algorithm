package baekjoon_online_judge.solved.q9498_시험성적;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        new Solution();
    }

    //입출력
    static class Solution {
        private Reader reader;
        private Writer writer;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;

        private Solution() {
            resourceOpen();
            execute();
        }

        //연산
        private void execute() {
            try{
                String input = bufferedReader.readLine().trim();
                bufferedWriter.write( calculate(input) );
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
        private String calculate(String input){
            String result = "";
            int score = getDecimalNumber(Integer.parseInt(input));
            switch (score){
                case 10:
                case 9:
                    result = "A";
                    break;
                case 8:
                    result = "B";
                    break;
                case 7:
                    result = "C";
                    break;
                case 6:
                    result = "D";
                    break;
                default:
                    result = "F";
                    break;
            }
            return result;
        }

        private int getDecimalNumber(int x){
            return x / 10;
        }

        /*---------------------------------------------*/
        //자원 할당
        private void resourceOpen(){
            reader = new InputStreamReader(System.in);
            writer = new OutputStreamWriter(System.out);
            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);
        }

        //자원 해제
        private void resourceClose() throws IOException {
            if (bufferedReader != null)     bufferedReader.close();
            if (bufferedWriter != null)     bufferedWriter.close();
            if (reader != null)             reader.close();
            if (writer != null)             writer.close();
        }
    }
}