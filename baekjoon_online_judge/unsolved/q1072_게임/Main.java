package baekjoon_online_judge.unsolved.q1072_����;

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
                StringBuilder sb = new StringBuilder();

                String input;
                while( !(input = bufferedReader.readLine().trim()).equals("0") ){
                    solve(sb, input);
                }



                bufferedWriter.write( sb.toString() );
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
        private void solve(StringBuilder sb, String input) {
            System.out.println("Solution.solve");
//            int x = Integer.parseInt(input[0]);
//            int y = Integer.parseInt(input[1]);

//            int now = x / y * 100;
//            int tmp = now;
//            while(
//
//            }

            sb.append("1");
            System.out.println(" ??? ");
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