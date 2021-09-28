package baekjoon_online_judge.solved.q15121_starArrangement;

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
                String input = bufferedReader.readLine().trim();
                bufferedWriter.write(calculate(input));
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
        private String calculate(String input) {
            int star = Integer.parseInt(input);
            int index = star / 2;
            if(star % 2 != 0){
                index++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(star)
                .append(":")
                .append("\n");

            for(int i=2 ; i<= index; i++){
                if(testDifferentNumber(star, i)){
                    printResult(sb, i, false);
                }
                if(testSameNumber(star, i)){
                    printResult(sb, i, true);
                }
            }
            return sb.toString();
        }

        private boolean testSameNumber(int star, int row){
            return star % row == 0;
        }

        private boolean testDifferentNumber(int star, int row){
            int compare = row * 2 - 1;
            return star % compare == 0 || (star - row) % compare == 0;
        }

        private void printResult(StringBuilder sb, int index, boolean same){
            sb.append(index).append(",");
            if(same){
                sb.append(index);
            } else {
                sb.append(index-1);
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