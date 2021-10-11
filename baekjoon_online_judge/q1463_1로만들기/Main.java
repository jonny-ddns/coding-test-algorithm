package baekjoon_online_judge.q1463_1�θ����;

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
                int number = Integer.parseInt(bufferedReader.readLine().trim());
                bufferedWriter.write( Integer.toString(solve(number)) );
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
        private int solve(int number) {



            return 0;
        }
        /*
        X�� 3���� ������ ��������, 3���� ������.
        X�� 2�� ������ ��������, 2�� ������.
        1�� ����.
        */
        private boolean calculate3(int x){
            return x % 3 == 0;
        }
        private boolean calculate2(int x){
            return x % 2 == 0;
        }
        private boolean minus1(int x){
            return x > 1;
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