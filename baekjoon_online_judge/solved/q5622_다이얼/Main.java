package baekjoon_online_judge.solved.q5622_다이얼;

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
        private int solve(String input) {
            int distance = 0;
            for (int i = 0; i < input.length(); i++) {
                distance += getNumber(input.charAt(i));
            }
            return distance;
        }

        private int getNumber(char ch){
            int result;
            switch (ch){
                case 'A':
                case 'B':
                case 'C':
                    result = 2;
                    break;
                case 'D':
                case 'E':
                case 'F':
                    result = 3;
                    break;
                case 'G':
                case 'H':
                case 'I':
                    result = 4;
                    break;
                case 'J':
                case 'K':
                case 'L':
                    result = 5;
                    break;
                case 'M':
                case 'N':
                case 'O':
                    result = 6;
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    result = 7;
                    break;
                case 'T':
                case 'U':
                case 'V':
                    result = 8;
                    break;
                default:
                    result = 9;
            }
            return result + 1;
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