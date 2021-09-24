package baekjoon_online_judge.solved.q4949_균형잡힌세상;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
                String input;
                while(!(input = bufferedReader.readLine()).equals(".")){
                    if(calculate(input)){
                        bufferedWriter.write("yes");
                    } else {
                        bufferedWriter.write("no");
                    }
                    bufferedWriter.write("\n");
                }
                bufferedWriter.flush();
            } catch (IOException ignored){
            } finally {
                try {
                    resourceClose();
                } catch (IOException ignored){
                }
            }
        }

        //연산
        private boolean calculate(String input) {
            Stack<Integer> stack = new Stack<>();
            for (byte b : input.getBytes(StandardCharsets.UTF_8)) {
                if(b == 40){
                    stack.push(40);
                    continue;
                }
                if(b == 91){
                    stack.push(91);
                    continue;
                }
                if(b == 41){
                    if(stack.empty() || stack.pop() != 40){
                        return false;
                    }
                }
                if(b == 93){
                    if(stack.empty() || stack.pop() != 91){
                        return false;
                    }
                }
            }
            return stack.empty();
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