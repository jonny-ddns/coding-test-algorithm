package baekjoon_online_judge.unsolved.q1257_엄청난부자;

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
                String money = bufferedReader.readLine().trim();
                String count = bufferedReader.readLine().trim();
                String[] coins = bufferedReader.readLine().trim().split(" ");
                bufferedWriter.write( Integer.toString(solve(money, count, coins))  );
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
        private int solve(String moneyStr, String countStr, String[] coinsArray) {
            int money = Integer.parseInt(moneyStr);
            int count = Integer.parseInt(countStr);

//            sort(coinsArray);



            return 0;
        }

        public void sort(int[] intArr){
            int i;
            int j;
            int value;
            for(i=1; i< intArr.length; i++){
                j = i-1;
                value = intArr[i];
                while(j >= 0 && value < intArr[j]){
                    intArr[j+1] = intArr[j];
                    j--;
                }
                intArr[j+1] = value;
            }
        }

//        public void sort2(String[] intArr){
//            int i;
//            int j;
//            int value;
//            for (i = 1; i < intArr.length; i++) {
//                j = i - 1;
//                value = Integer.parseInt(intArr[i]);
//                while (j >= 0 && value < Integer.parseInt(intArr[j])) {
//                    intArr[j + 1] = intArr[j];
//                    j--;
//                }
//                intArr[j + 1] = value;
//            }
//        }


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