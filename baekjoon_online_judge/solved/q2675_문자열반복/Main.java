package baekjoon_online_judge.solved.q2675_문자열반복;

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
                int count = Integer.parseInt(bufferedReader.readLine().trim());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count ; i ++) {
                    String[] input = bufferedReader.readLine().split(" ");
                    bufferedWriter.write(solve(sb, input));
                }
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
        private String solve(StringBuilder sb, String[] input) {
            sb.setLength(0);
            int repetition = Integer.parseInt(input[0]);
            String str = input[1];

            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < repetition; j++) {
                    sb.append(str.charAt(i));
                }
            }
            sb.append("\n");
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