package baekjoon_online_judge.solved.q11024_더하기4;

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
                int count = Integer.parseInt(bufferedReader.readLine().trim());
                StringBuilder sb = new StringBuilder();
                int turn = 0;
                while (turn < count){
                    calculate(sb, bufferedReader.readLine().split(" "));
                    turn++;
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
        private void calculate(StringBuilder sb, String[] array) {
            int sum = 0;
            int i;
            for (i = 0; i < array.length; i++) {
                sum += Integer.parseInt(array[i]);
            }
            sb.append(sum).append("\n");
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