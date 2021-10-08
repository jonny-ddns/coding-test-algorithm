package baekjoon_online_judge.q11051_���װ��2;

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
                String[] input = bufferedReader.readLine().trim().split(" ");
                bufferedWriter.write( Integer.toString(solve(input))  );
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
        private int solve(String[] input) {
            /*
            Ư�� ������ ������ ���ϱ�
            -> ū ���ڴ� �Ÿ����� ����

             */

//            for(){
//
//            }
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            int multiOn = 1;
            for (int i = 0; i < k; i++) {
                multiOn *= (n-i);
                if(10000 < multiOn){

                }
            }
            /*

            103


            110 111 112 �������� �������� > �׷���...?

             */


            int multiUnder = 1;
            for (int i = 1; i <= k; i++) {
                multiUnder *= i;
            }
            int divide = 10007;
            return (multiOn / multiUnder) % divide;
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