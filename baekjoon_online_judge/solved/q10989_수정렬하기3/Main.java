package baekjoon_online_judge.solved.q10989_수정렬하기3;

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
                int[] countArray = new int[10001];
                for (int i = 0; i < countArray.length - 1; i++) {
                    countArray[i] = 0;
                }
                int count = Integer.parseInt(bufferedReader.readLine().trim());

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    int number = Integer.parseInt(bufferedReader.readLine().trim());
                    arrayInsert(countArray, number);
                }
                bufferedWriter.write( arrayString(countArray, sb).toString() );
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

        private void arrayInsert(int[] array, int index) {
            array[index] = array[index] + 1;
        }

        private StringBuilder arrayString(int[] array, StringBuilder sb){
            int count;
            int i;
            for (i = 1; i < array.length; i++) {
                count = array[i];
                if(count != 0){
                    for (int j = 0; j < count; j++) {
                        sb.append(i).append("\n");
                    }
                }
            }
            return sb;
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