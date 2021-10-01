package baekjoon_online_judge.unsolved.q2751_수정렬하기2;

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
                int count = Integer.parseInt(bufferedReader.readLine());
                int[] numbers = new int[count];
                int i;
                for (i = 0; i < count; i++) {
                    calculate(numbers, i, bufferedReader.readLine().trim());
                }
                for (int result : numbers) {
                    bufferedWriter.write(Integer.toString(result));
                    bufferedWriter.write( "\n" );
                }
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
        private void calculate(int[] numbers, int count, String str){
            int n = Integer.parseInt(str);
            for (int i = 0; i <= count; i++) {
                if(n < numbers[i]){
                    numbers[i] = n;
                    break;
                }
                if(i == count){
                    numbers[i] = n;
                }
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