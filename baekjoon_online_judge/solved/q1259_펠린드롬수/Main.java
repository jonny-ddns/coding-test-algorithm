package baekjoon_online_judge.solved.q1259_�縰��Ҽ�;

import java.io.*;
import java.util.Stack;

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
            if(isProper(input)){
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
        }

        private boolean isProper(String str){
            boolean isEven = str.length() % 2 == 0;

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length() / 2; i++) {
                stack.push(str.charAt(i));
            }

            int peekStart = str.length() / 2;
            if (!isEven) {
                peekStart++;
            }
            for (int i = peekStart; i < str.length(); i++) {
                if(stack.peek() == str.charAt(i)){
                    stack.pop();
                } else {
                    return false;
                }
            }
            return true;
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