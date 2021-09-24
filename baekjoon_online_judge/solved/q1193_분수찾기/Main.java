package baekjoon_online_judge.solved.q1193_분수찾기;

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
//            resourceOpen();
//            execute();
            for(int i=1; i<21 ;i++){
                calculate(i);
//                System.out.println(i + " -> "+ find(i)[0] + " | "+ find(i)[1]);
            }
        }

        //입출력
        private void execute() {
            try{
                int index = Integer.parseInt(bufferedReader.readLine());
                bufferedWriter.write(calculate(index));
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
        private String calculate(int number) {
            int[] array = find(number);
//            int sum = array[0] +1;
            int sum = array[0];
            int index = sum - array[1];
            int son;
            int mom;


            if(sum % 2 == 0){

            } else {
                index = array[1] + 1;
            }


            String result = sum + "/"+ index;
            System.out.println(result);

            return result;
        }

        private int[] find(int number){
            number--;
            int result = 1;
            int n = 1;
            int sum = 0;
            boolean find = false;
            while(!find){
                sum = n * (n+1) / 2;
                if(number < sum){
                    result = n;
                    find = true;
                }
                n++;
            }
            return new int[]{result, sum - number};
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
