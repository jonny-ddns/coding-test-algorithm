package baekjoon_online_judge.solved.q9316_helloJudge;

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

        //입출력 수행
        private void execute() {
            try{
                bufferedWriter.write( calculate(bufferedReader.readLine().trim()) );
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
        private String calculate(String str) {
            StringBuilder sb = new StringBuilder();
            String hello = "Hello World, Judge ";

            int turn = 0;
            while (turn < Integer.parseInt(str)){
                turn++;
                sb.append(hello)
                        .append(turn)
                        .append("!")
                        .append("\n");
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