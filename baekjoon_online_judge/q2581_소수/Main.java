package baekjoon_online_judge.q2581_�Ҽ�;

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
                String M = bufferedReader.readLine().trim();
                String N = bufferedReader.readLine().trim();
                bufferedWriter.write( solve(M, N) );
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
        private String solve(String x, String y) {
            int start = Integer.parseInt(x);
            int end = Integer.parseInt(y);
            return sum(start, end) + "\n" + min(start, end);
        }
        
        //1. �Ҽ��� ��
        private int sum(int x, int y){

            return 0;

        }
        
        
        
        //2. �ּڰ�
        private int min(int x, int y){
                     return 0;
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