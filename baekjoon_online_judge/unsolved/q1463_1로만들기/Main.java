package baekjoon_online_judge.unsolved.q1463_1로만들기;

import java.io.*;

//https://freedeveloper.tistory.com/276
/*
    X가 3으로 나누어 떨어지면, 3으로 나눈다.
    X가 2로 나누어 떨어지면, 2로 나눈다.
    1을 뺀다.
 */
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
                int result = calculate( bufferedReader.readLine().trim() );
                bufferedWriter.write(Integer.toString(result));
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
        private int calculate(String str){
            int number = Integer.parseInt(str);

            int result = 0;
            int count = 0;
            while(number!=1){
                number = repetition(number);
                System.out.println("number = "+ number);
                count++;
            }
            System.out.println("count = " + count);
            return result;
        }

        private int repetition(int number){
            System.out.print("number = "+ number);
            System.out.print(" | ");
            if(number % 3 == 0){
                return number / 3;
            }
            if(number % 2 == 0){
                return number / 2;
            }
            if(number > 2){
                return --number;
            }
            return 1;
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