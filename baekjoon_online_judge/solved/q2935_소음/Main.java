package baekjoon_online_judge.solved.q2935_����;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        new Solution();
    }

    //��øŬ����
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
                String number1 = bufferedReader.readLine().trim();
                String calculate = bufferedReader.readLine().trim();
                String number2 = bufferedReader.readLine().trim();
                bufferedWriter.write( solve(number1, number2, calculate) );
                bufferedWriter.flush();
            } catch (IOException ignored){
            } finally {
                try {
                    resourceClose();
                } catch (IOException ignored){
                }
            }
        }

        //����
        private String solve(String input1, String input2, String calculate){
            int spot1 = input1.length() - 1;
            int spot2 = input2.length() - 1;
            StringBuilder sb = new StringBuilder();

            //���ϱ�
            if(calculate.equals("*")){
                sb.append("1");
                for (int i = 0; i < spot1 + spot2; i++) {
                    sb.append("0");
                }
                return sb.toString();
            }

            //���ϱ�
            if (spot1 == spot2) {
                sb.append("2");
                for (int i = 0; i < spot1; i++) {
                    sb.append("0");
                }
                return sb.toString();
            }

            if (spot1 < spot2) {
                int tmp = spot1;
                spot1 = spot2;
                spot2 = tmp;
            }

            sb.append("1");
            for (int i = 0; i < spot1 - spot2 - 1; i++) {
                sb.append("0");
            }
            sb.append("1");
            for (int i = 0; i < spot2; i++) {
                sb.append("0");
            }
            return sb.toString();
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