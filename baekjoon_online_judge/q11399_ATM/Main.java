package baekjoon_online_judge.q11399_ATM;

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
                bufferedReader.readLine();
                bufferedWriter.write(
                    Integer.toString( calculate(bufferedReader.readLine().split(" ")) )
                );
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
        private int calculate(String[] line) {
            return sum( sort( toIntArray(line) ) );
        }

        //int 형 변환
        private int[] toIntArray(String[] A){
            int[] B = new int[A.length];
            int i;
            for (i = 0; i < A.length; i++) {
                B[i] = Integer.parseInt(A[i]);
            }
            return B;
        }

        //정렬
        private int[] sort(int[] a){
            for(int i = 1; i < a.length; i++) {
                int target = a[i];
                int j = i - 1;
                while(j >= 0 && target < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = target;
            }
            return a;
        }

        //시간합 구하기
        private int sum(int[] a){
            int sum = 0;
            int i;
            for(i=0; i<a.length; i++){
                sum += a[i] * (a.length - i);
            }
            return sum;
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