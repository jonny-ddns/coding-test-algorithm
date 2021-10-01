package baekjoon_online_judge.solved.q10769_행복한지슬픈지;

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
            int[] feelArray = new int[]{0, 0};    //happy, sad
            int feel;
            for (int i = 0; i < input.length() - 2 ; i++) {
                if(input.startsWith(":-", i)){
                   feel = compareChar(input.charAt(i + 2));
                   if(feel == 1){
                       feelArray[0]++;
                   }
                   if(feel == -1){
                       feelArray[1]++;
                   }
                }
            }
            return defineFeeling(feelArray);
        }

        //happy, sad, none 판단하기
        private int compareChar(char ch) {
            int result;
            switch (ch) {
                case ')':
                    result = 1;
                    break;
                case '(':
                    result = -1;
                    break;
                default:
                    result = 0;
            }
            return result;
        }

        private String defineFeeling(int[] feelArray){
            int happy = feelArray[0];
            int sad = feelArray[1];

            if(sad < happy){
                return "happy";
            }
            if(happy < sad){
                return "sad";
            }
            if(happy != 0){
                return "unsure";
            }
            return "none";
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