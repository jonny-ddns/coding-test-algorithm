package baekjoon_online_judge.solved.q11653_���μ�����;

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
                String input = bufferedReader.readLine().trim();
                bufferedWriter.write( solve(input) );
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
        private String solve(String input) {
            StringBuilder sb = new StringBuilder();
            int number = Integer.parseInt(input);
            int copy = number;
            int length = copy / 2 + 1;
            int repetition;
            int[] result;
            for (int i = 2; i < length; i++) {
                result = calculate(copy, i);
                copy = result[0];
                repetition = result[1];

                //�μ� �ƴ�
                if(repetition == 0){
                    continue;
                }

                //���ڿ� ����
                int turn = 0;
                while (turn < repetition) {
                    sb.append(i).append("\n");
                    turn++;
                }
                //���μ����� ����
                if(copy == 1){
                    break;
                }
            }
            //�μ� ����
            if(sb.length() == 0 && number != 1){
                sb.append(number);
            }
            return sb.toString();
        }

        //x�� y�� ������ -> �������, ����Ƚ��
        private int[] calculate(int x, int y){
            if(x % y != 0){
                return new int[]{x, 0};
            }
            int count = 1;
            while( x % Math.pow(y, count) == 0 ){
                count++;
            }
            int remain = x / (int) Math.pow(y, --count);
            return new int[]{remain, count};
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