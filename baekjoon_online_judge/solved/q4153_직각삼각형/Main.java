package baekjoon_online_judge.q4153_직각삼각형;

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
                String[] input;
                while (!(input = bufferedReader.readLine().trim().split(" "))[0].equals("0")) {
                    solve(sb, input);
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
        private void solve(StringBuilder sb, String[] input) {
            if(isTriangle(input)){
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            sb.append("\n");
        }

        private boolean isTriangle(String[] input){
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);
            int[] sides = new int[]{x, y, z};
            int index = maxIndex(x, y, z);
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                if(i == index){
                    continue;
                }
                sum += Math.pow(sides[i], 2);
            }
            return sum == Math.pow(sides[index], 2);
        }

        private int maxIndex(int x, int y, int z){
            if (Math.max(x, y) == x) {
                if(Math.max(x, z) == x){
                    return 0;
                }
                return 2;
            }
            if (Math.max(y, z) == y) {
                return 1;
            }
            return 2;
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