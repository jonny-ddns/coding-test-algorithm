package baekjoon_online_judge.unsolved.q22872_공옮기기;
/*
피보나치
1
    1 2
    2 3
2
    1 2
    1 3
    2 3
3
    1 2
    1 2
    1 3
    2 3
    2 3
 */

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
//            for(int i=0;i<10;i++) {
//                System.out.print(i + " ");getMovingCount(i);
//            }
        }

        //입출력 수행
        private void execute() {
            try{
                int N = Integer.parseInt(bufferedReader.readLine());
                bufferedWriter.write(calculate(N));
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
        private String calculate(int N) {
            StringBuilder sb = new StringBuilder();
            int count = getMovingCount(N);
            sb.append(count).append("\n");
            getMovingProcess(sb, N, count);
            return sb.toString();
        }

        //공을 옮기는 횟수 M
        private int getMovingCount(int N){
            N ++;
            if(N == 1){
                return 1;
            }
            int result = 1;
            int a = 0;
            int b = 1;
            int i;
            for (i = 1; i <= N; i++) {
                result = a + b;
                a = b;
                b = result;
            }
            return result;
        }

        //공을 옮기는 과정
        private void getMovingProcess(StringBuilder sb, int N, int count){
            int moving = getMovingCount(N-2);
            int remain = count - 2 * moving;

            String s12 = "1 2";
            String s13 = "1 3";
            String s23 = "2 3";

            if(N == 1){
                sb.append(s12).append("\n");
                sb.append(s13).append("\n");
                return;
            }
            if(N == 2){
                sb.append(s12).append("\n")
                    .append(s13).append("\n")
                    .append(s23).append("\n");
                return;
            }

            int turn = 0;
            while (turn < moving) {
                sb.append(s12).append("\n");
                turn++;
            }

            turn = 0;
            while (turn < remain) {
                sb.append(s13).append("\n");
                turn++;
            }

            turn = 0;
            while (turn < moving) {
                sb.append(s23).append("\n");
                turn++;
            }
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