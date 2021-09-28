package baekjoon_online_judge.solved.q9012_괄호;

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

        private void execute() {
            try{
                //입력
                int count = Integer.parseInt(bufferedReader.readLine().trim());
                boolean[] result = new boolean[count];
                for(int i=0; i<count; i++){
                    result[i] = solve(bufferedReader.readLine().trim());
                }

                //출력
                for (boolean b: result) {
                    if(b){
                        bufferedWriter.write("YES");
                    } else {
                        bufferedWriter.write("NO");
                    }
                    bufferedWriter.write("\n");
                }
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
        private boolean solve(String input) {
            if(! (input.length() % 2 == 0 &&compareStartEnd(input) && compareCount(input)) ){
                return false;
            }

            Stack<Boolean> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                String sub = input.substring(i, i + 1);
                if(sub.equals("(")){
                    stack.push(true);
                    continue;
                }
                if(sub.equals(")") && stack.size() != 0){
                    stack.pop();
                    continue;
                }
                return false;
            }
            return stack.size() == 0;
        }

        private boolean compareStartEnd(String input){
            return input.startsWith("(") && input.lastIndexOf(")") == input.length() - 1;
        }

        private boolean compareCount(String input){
            int countLeft = 0;
            int countRight = 0;
            for(int i=0; i<input.length(); i++){
                if(input.charAt(i) == '('){
                    countLeft++;
                } else {
                    countRight++;
                }
            }
            return countLeft == countRight;
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