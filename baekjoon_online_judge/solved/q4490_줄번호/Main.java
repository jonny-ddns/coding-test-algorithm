package baekjoon_online_judge.solved.q4490_줄번호;

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
                int repetition = Integer.parseInt(bufferedReader.readLine());
                String[] result = new String[repetition];
                String input;

                int turn = 0;
                while (turn < repetition) {
                    input = bufferedReader.readLine();
                    result[turn++] = calculate(input, turn);
                }
                for (String s : result) {
                    bufferedWriter.write(s);
                    bufferedWriter.write("\n");
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
        private String calculate(String input, int turn) {
            return turn + ". " + input;
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