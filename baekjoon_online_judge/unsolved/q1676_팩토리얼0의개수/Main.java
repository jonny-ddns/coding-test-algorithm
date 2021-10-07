package baekjoon_online_judge.q1676_팩토리얼0의개수;

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
//            for(int i=1; i<100; i++){
//                System.out.print("i = " + i+ " ");
//                long t = test(i);
//                System.out.println(t);
//
//            }
            resourceOpen();
            execute();
        }

        //입출력
        private void execute() {
            try {
                int number = Integer.parseInt(bufferedReader.readLine().trim());
                bufferedWriter.write(Integer.toString(solve(number)));
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
        private int solve(int number) {
            return number / 5;
        }

        private long test(int n){
            if(n == 1){
                return 1;
            }
            return n * test(n - 1);
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