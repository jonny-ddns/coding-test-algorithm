package baekjoon_online_judge.unsolved.q1009_분산처리;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        new Solution();
    }

    //중첩클래스
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
                int count = Integer.parseInt(bufferedReader.readLine());
                int turn = 0;
                while(turn < count){
                    bufferedWriter.write(
                            Integer.toString( calculate(bufferedReader.readLine().split(" ")) )
                    );
                    bufferedWriter.write( "\n" );
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
        private int calculate(String[] numbers){
            int a = getUnderTen(Integer.parseInt(numbers[0]));
            int b = reduceB(a, Integer.parseInt(numbers[1]));
            int result = 1;
            int turn = 0;
            while (turn < b){
                result *= a;
                result = getUnderTen(result);
                turn++;
            }
            return result;
        }

        //a -> 1의 자리만 추출하기
        private int getUnderTen(int a){
            if(a < 10){
                return a;
            }
            return a - (a / 10) * 10;
        }

        //b -> 지수값 감소시키기
        private int reduceB(int a, int b){
            switch (a){
                case 2:
                case 3:
                case 7:
                case 8:
                    b = b % 4 + 4;
                    break;
                case 4:
                case 9:
                    b = b % 2 + 2;
                    break;
                default:    //1, 5, 6
                    b = 1;
            }
            return b;
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