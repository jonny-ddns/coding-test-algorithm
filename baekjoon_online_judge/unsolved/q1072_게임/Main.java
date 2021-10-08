package baekjoon_online_judge.unsolved.q1072_게임;

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

        //연산
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