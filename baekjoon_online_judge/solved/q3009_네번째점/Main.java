package baekjoon_online_judge.solved.q3009_네번째점;

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
                int count = 3;
                int[][] input = new int[count][];
                int turn = 0;
                while (turn < count) {
                    input[turn++] = toIntArray(bufferedReader.readLine().trim().split(" "));
                }
                int[] result = solve(input);
                bufferedWriter.write(Integer.toString(result[0]));
                bufferedWriter.append(" ");
                bufferedWriter.write(Integer.toString(result[1]));
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
        private int[] solve(int[][] input) {
            int[] edges = new int[6];
            int[] result = new int[2];

            edges[0] = input[0][0];
            edges[1] = input[0][1];
            edges[2] = input[1][0];
            edges[3] = input[1][1];
            edges[4] = input[2][0];
            edges[5] = input[2][1];

            if(edges[0] == edges[2]){
                result[0] = edges[4];
            } else if(edges[2] == edges[4]) {
                result[0] = edges[0];
            } else {
                result[0] = edges[2];
            }

            if(edges[1] == edges[3]){
                result[1] = edges[5];
            } else if(edges[3] == edges[5]) {
                result[1] = edges[1];
            } else {
                result[1] = edges[3];
            }
            return result;
        }

        int[] toIntArray(String[] s){
            int[] result = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                result[i] = Integer.parseInt(s[i]);
            }
            return result;
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