package baekjoon_online_judge.solved.q10870_피보나치수5;

import java.io.*;
import java.util.Arrays;

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
                int index = Integer.parseInt(bufferedReader.readLine().trim());
                bufferedWriter.write( Integer.toString(solve(index)) );
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
        private int solve(int index) {
            int[] record = new int[index + 1];
            Arrays.fill(record, -1);

            for (int i = 0; i <= index; i++) {
                if (i < 2) {
                    record[i] = i;
                    continue;
                }
                if(record[i] == -1){
                    record[i] = record[i - 2] + record[i - 1];
                }
            }
            return record[index];
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