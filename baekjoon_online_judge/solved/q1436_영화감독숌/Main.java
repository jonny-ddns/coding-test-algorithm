package baekjoon_online_judge.solved.q1436_영화감독숌;

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
                String input = bufferedReader.readLine().trim();
                bufferedWriter.write( Integer.toString(solve(input)) );
                bufferedWriter.flush();
//                int result = test(bufferedReader.readLine());
//                System.out.println(result);
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
//          //다른 소스
//        private int test(String str){
//            int n = Integer.parseInt(str);
//            int num = 666;
//            int count = 1;
//            while (count < n) {
////                System.out.println("num = "+ num);
//                num++;
//                int x = num;
//                while (x > 100) {
//                    System.out.println("x = " + x);
//
//                    if (x % 1000 == 666) {
//                        System.out.println("나머지가 666입니다 고로 count ++");
//                        count++;
//                        break;
//                    }
//                    x /= 10;
//                    System.out.println("10으로 나눈다");
//                }
//            }
//            return num;
//        }

        private int solve(String input) {
            return getTitle666(Integer.parseInt(input));
        }

        private int getTitle666(int condition){
            int turn = 0;
            int number = 665;
            while(turn < condition){
                if(check666(++number)){
                    turn++;
                }
            }
            return number;
        }

        private boolean check666(int number){
            if(number < 666) {
                return false;
            }
            String s = Integer.toString(number);
            if (!s.contains("6") || s.length() - 3 < s.indexOf("6") || s.lastIndexOf("6") < 2) {
                return false;
            }
            for (int i = 0; i < s.length() - 2; i++) {
                if (s.charAt(i) == '6' && s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + 2)) {
                    return true;
                }
            }
            return false;
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