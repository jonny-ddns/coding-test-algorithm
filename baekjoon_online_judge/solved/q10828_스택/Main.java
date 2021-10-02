package baekjoon_online_judge.solved.q10828_스택;

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

        //입출력
        private void execute() {
            try{
                Stack<Integer> stack = new Stack<>();
                StringBuilder sb = new StringBuilder();
                int count = Integer.parseInt(bufferedReader.readLine().trim());

                for (int i = 0; i < count; i++) {
                    solve(stack, sb, bufferedReader.readLine().trim());
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
        private void solve(Stack<Integer> stack, StringBuilder sb, String input){
            if(5 < input.length()){
                stack.push(Integer.parseInt(input.split(" ")[1]));
                return;
            }

            int result = -1;
            switch (input.charAt(0)){
                case 'p':
                    if(stack.size() != 0){
                        result = stack.pop();
                    }
                    break;
                case 's':
                    result = stack.size();
                    break;
                case 'e':
                    if(stack.isEmpty()){
                        result = 1;
                        break;
                    }
                    result =  0;
                    break;
                case 't':
                    if(stack.size() != 0){
                        result = stack.peek();
                        break;
                    }
            }
            sb.append(result).append("\n");
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