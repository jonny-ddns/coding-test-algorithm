package baekjoon_online_judge.unsolved.q1929_소수구하기;

import java.io.*;
import java.util.Arrays;

/*
M이상  N 이하의 소수를 모두 출력하는 프로그램을 작성하시오.
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다.
(1 ≤ M ≤ N ≤ 1,000,000) M이상 N 이하의 소수가 하나 이상 있는 입력만 주어진다.
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
                StringBuilder sb = new StringBuilder();
                String[] input = bufferedReader.readLine().split(" ");
                solve(sb, input);
                bufferedWriter.write( sb.toString());
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
        private void solve(StringBuilder sb, String[] input) {
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            if(start == 1){
                start++;
            }

            boolean[] booleanArray = new boolean[end - start + 1];
            Arrays.fill(booleanArray, true);
            System.out.println("모두 true 설정");

            check2357(booleanArray, start);
            System.out.println("2357 설정");
            
            for (int i = 0; i < booleanArray.length; i++) {
                if(booleanArray[i]){
                    System.out.println(i + " - 확인해야겠네요");
                    isPrime(booleanArray, start, i);
                    checkRemain(booleanArray, start, end, i);
                }
            }
            System.out.println("에라토스 체크");
            startCheck(sb, start);
            for (int i = 0; i <= end-start; i++) {
                if(booleanArray[i]){
                    sb.append(i + start).append("\n");
                }
            }
        }

        private void check2357 (boolean[] array, int start){
            int tmp;
            for (int i = 0; i < array.length; i++) {
                tmp = i + start;
                if(tmp % 2 == 0 || tmp % 3 == 0 || tmp % 5 == 0 || tmp % 7 == 0) {
                    array[i] = false;
                }
            }
        }

        private void isPrime(boolean[] booleans, int start, int index) {
            System.out.println("실제 숫자 = " + (start + index));
            int number = start + index;
            int limit = number / 2;
            int i;
            for (i = 2; i <= limit; i++) {
                if (number % i == 0) {
                    System.out.println(number + " -> 소수가 아닙니다");
                    booleans[index] = false;
                    return;
                }
            }
        }

        private void checkRemain(boolean[] booleanArray, int start, int end, int i) {
            if (i < 4) {
                return;
            }
            int realNumber = start + i;
            int count = 1;
            int index;
            while ((index = realNumber * (++count)) <= end) {
                booleanArray[index - start] = false;
            }
        }

        private void startCheck(StringBuilder sb, int start){
            if(start <= 2){
                sb.append(2).append("\n");
            }
            if(start <= 3){
                sb.append(3).append("\n");
            }
            if(start <= 5){
                sb.append(5).append("\n");
            }
            if(start <= 7){
                sb.append(7).append("\n");
            }
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