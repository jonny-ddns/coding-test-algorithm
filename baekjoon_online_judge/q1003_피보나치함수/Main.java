package baekjoon_online_judge.q1003_피보나치함수;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        new Solution();
    }

    static class Solution {
        private Reader reader;
        private Writer writer;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;
        private HashMap<Boolean, Integer> map;

        private Solution() {
            resourceOpen();
            execute();
        }

        //입출력
        private void execute() {
            try{
                int count = Integer.parseInt(bufferedReader.readLine());
                int turn = 0;
                while(turn < count){
                    int[] result = calculate(bufferedReader.readLine());
                    bufferedWriter.write( Integer.toString( result[0] ) );
                    bufferedWriter.write( " " );
                    bufferedWriter.write( Integer.toString( result[1] ) );
                    bufferedWriter.write("\n");
                    turn++;
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
        private int[] calculate(String input) {
            int number = Integer.parseInt(input);
            fibonacci(number);
            int t = 0;
            if(map.containsKey(true)){
                t = map.get(true);
            }
            int f = 0;
            if(map.containsKey(false)){
                f = map.get(false);
            }
            map.clear();
            return new int[]{f, t};
        }

        void fibonacci(int n) {
            if (n == 0) {
                if(map.containsKey(false)){
                    map.put(false, map.get(false) + 1);
                    return;
                }
                map.put(false, 1);
            } else if (n == 1) {
                if(map.containsKey(true)){
                    map.put(true, map.get(true) + 1);
                    return;
                }
                map.put(true, 1);
            } else {
                fibonacci(n-1);
                fibonacci(n-2);
            }
        }

        /*---------------------------------------------*/
        //자원할당
        private void resourceOpen(){
            reader = new InputStreamReader(System.in);
            writer = new OutputStreamWriter(System.out);
            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);
            map = new HashMap<>();
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