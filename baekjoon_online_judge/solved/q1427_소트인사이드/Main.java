package baekjoon_online_judge.solved.q1427_소트인사이드;

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
                bufferedWriter.write( solve(input) );
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
        private String solve(String input) {
            StringBuilder sb = new StringBuilder();
            int index;
            int count = input.length();
            for (int i = 0; i < count; i++) {
                index = max(input);
                sb.append(input.charAt(index));
                input = input.substring(0, index) + input.substring(index + 1);
            }
            return sb.toString();
        }

        private int max(String input){
            int index = 0;
            int max = 0;
            int value;
            for (int i = 0; i < input.length(); i++) {
                value = Integer.parseInt(input.substring(i, i+1));
                if(max <= value){
                    max = value;
                    index = i;
                }
            }
            return index;
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