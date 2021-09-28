package baekjoon_online_judge.solved.q1419_등차수열의합;

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
                String left     = bufferedReader.readLine().trim();
                String right    = bufferedReader.readLine().trim();
                String k        = bufferedReader.readLine().trim();

                bufferedWriter.write( Integer.toString(calculate(left, right, k)) );
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
        private int calculate(String s1, String s2, String s3){
            int left = Integer.parseInt(s1);
            int right = Integer.parseInt(s2);
            int k = Integer.parseInt(s3);
            int leftMok;
            int rightMok;
            int result = 0;

            int limit = k * (k + 1) / 2;
            if(right < limit){
                return 0;
            }
            if(left < limit){
                left = limit;
            }

            switch (k){
                case 2:
                    result = right - left + 1;
                    break;
                case 3:
                    leftMok = (int) Math.ceil(left / 3d);
                    rightMok = right / 3;
                    result = rightMok - leftMok + 1;
                    break;
                case 4:
                    leftMok = (int) Math.ceil(left / 2d);
                    rightMok = right / 2;
                    result = rightMok - leftMok + 1;
                    if(leftMok <= 6 && 6 <= rightMok){
                        result--;
                    }
                    break;
                case 5:
                    leftMok = (int) Math.ceil(left / 5d);
                    rightMok = right / 5;
                    result = rightMok - leftMok + 1;
                    break;
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
            if (bufferedReader != null)     bufferedReader.close();
            if (bufferedWriter != null)     bufferedWriter.close();
            if (reader != null)             reader.close();
            if (writer != null)             writer.close();
        }
    }
}