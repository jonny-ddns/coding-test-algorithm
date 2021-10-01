package baekjoon_online_judge.q11047_����0;

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

        //�����
        private void execute() {
            try{
                String[] condition = bufferedReader.readLine().split(" ");
                int count = Integer.parseInt(condition[0]);
                int money = Integer.parseInt(condition[0]);
                String[] numbers = new String[count];

                for (int i = 0; i < count; i++) {
                    numbers[i] = bufferedReader.readLine().trim();
                }


                bufferedWriter.write( Integer.toString(solve(numbers, money)) );
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

        //����
        private Integer solve(String[] input, int money) {
            return calculate(toIntArray(input), money);
        }

        private int[] toIntArray(String[] array){
            int[] result = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = Integer.parseInt(array[i]);
            }
            return result;
        }

        /*
        5500
        -> 1000 * 5
        ->
         */
        private int calculate(int[] numbers, int goal){
            int remain = goal;
            int count = 0;
            int mok;
            while(remain != 0){
                for (int i = numbers.length - 1; i >= 0; i--) {
                    System.out.println(i + "��°�� = " + numbers[i]);
                    if((mok = remain / numbers[i]) != 0){   //����������
//                        mok = remain / numbers[i];
                        count += mok;
                        System.out.println("mok = " + mok);
                        remain = remain % numbers[i];
                        System.out.println(numbers[i]);
                        System.out.println("remain = " + remain);

                        threadSleep();
                    } else {
                        System.out.println(goal + " ������ " + numbers[i] + " ����");
                    }
                }
            }
            return count;
        }


        void threadSleep(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {

            }
        }

        /*---------------------------------------------*/
        //�ڿ��Ҵ�
        private void resourceOpen(){
            reader = new InputStreamReader(System.in);
            writer = new OutputStreamWriter(System.out);
            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);
        }

        //�ڿ�����
        private void resourceClose() throws IOException {
            if (reader != null)             reader.close();
            if (writer != null)             writer.close();
            if (bufferedReader != null)     bufferedReader.close();
            if (bufferedWriter != null)     bufferedWriter.close();
        }
    }
}