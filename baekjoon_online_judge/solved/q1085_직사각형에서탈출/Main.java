package baekjoon_online_judge.solved.q1085_직사각형에서탈출;

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
                String[] input = bufferedReader.readLine().split(" ");
                bufferedWriter.write( Integer.toString(solve(input)) );
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
        private int solve(String[] input){
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            int h = Integer.parseInt(input[3]);
            int ceiling = w - x;
            int right = h - y;
            return Math.min(Math.min(x, right), Math.min(y, ceiling));
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