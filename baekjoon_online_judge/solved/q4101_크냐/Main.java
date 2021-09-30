package baekjoon_online_judge.solved.q4101_크냐;

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
                StringBuilder sb = new StringBuilder();
                int count = Integer.parseInt(bufferedReader.readLine().trim());
                int turn = 0;
                while (turn < count) {
                    solve(sb, bufferedReader.readLine().trim().split(" "));
                    turn++;
                }
                bufferedWriter.write(sb.toString());
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
        private void solve(StringBuilder sb, String[] numbers){
            makeString(
                    sb
                    , compareProfit(
                            Integer.parseInt(numbers[1]) - Integer.parseInt(numbers[2])
                            , Integer.parseInt(numbers[0]))
            );
        }

        private int compareProfit(int ad, int now) {
            return Integer.compare(ad, now);
        }

        private void makeString(StringBuilder sb, int result){
            switch (result){
                case -1:
                    sb.append("do not advertise");
                    break;
                case 1:
                    sb.append("advertise");
                    break;
                default:
                    sb.append("does not matter");
                    break;
            }
            sb.append("\n");
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