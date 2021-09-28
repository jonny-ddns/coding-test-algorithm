package baekjoon_online_judge.q4144_alienCommunicatingMachines;

import java.io.*;

/*
개수
x y z
x 진법
y 진법
z -> x 진법으로 쓰여짐 -> y 진법으로 출력하시오
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
//            resourceOpen();
//            execute();
            test(10);

        }

        //입출력 수행
        private void execute() {
            try{
                int count = Integer.parseInt(bufferedReader.readLine().trim());
                String[] result = new String[count];
                int i;
                for(i=0; i<count; i++){
                    result[i] = solve(bufferedReader.readLine().split(" "));
                }

                for (String s: result) {
                    bufferedWriter.write(s);
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
        private String solve(String[] input) {
            int x = Integer.parseInt(input[0]); //진법
            int y = Integer.parseInt(input[1]); //진법
            String z = input[2];            //변환하기
            int decimalX = getX(x, z);      //10진법으로 가져옴
            return setY(y, decimalX);
        }

        //진법변환. x진법 -> 10진법
        private int getX(int x, String z){
            int number;
            int count = 0;
            int sum = 0;
            for (int i = z.length() -1; i>=0 ; i--) {
                number = changeUnit_alienToDecimal(z.substring(i, i + 1));  //실제값
                sum += number * Math.pow(x, count++);
            }
            return sum;
        }

        //진법변환. 10진법 -> y진법
        /*
        진법 변환하기
        10진법 7을 2진법으로 바꾸려면
             7을 2로 계속 나누기
             1이 나올 떄까지
             7 나머지를 계속 더하면 됨
         */
        private String setY(int y, int decimalX){
            String number = Integer.toString(decimalX);
            int count = 0;
            int multiply;

            int tmp = decimalX;

            while(true){
                int remain = tmp % y;   //나머지
                int mok = tmp / y; //몫
//                if(){
//
//                }
                break;
            }

//            for (int i = number.length() - 1; i >= 0; i--) {
//
////                multiply = Integer.parseInt(number.substring(i, i + 1)) * (int) Math.pow(y, count++);
////                changeUnit_decimalToAlien(multiply);
//            }
            return null;
        }
        
        //2진법 변환 확인
        void test(int number){
            int mok = 2;
            int remain;
            int tmp = number;

            do {
                remain = number % 2;
                mok = number / 2;
                tmp = mok;
                System.out.println(remain);
            } while (tmp >= 2);
            
        }
        

        //단위 변환. 10진법으로
        private int changeUnit_alienToDecimal(String subZ){
            if(isNumber(subZ)){
                return Integer.parseInt(subZ);
            }
            return subZ.getBytes()[0] - 54;
        }

        //단위 변환. y 진법으로
        private String changeUnit_decimalToAlien(int y, int decimal){
//            if(isNumber(subZ)){
//                return Integer.parseInt(subZ);
//            }
//            return subZ.getBytes()[0] - 54;
            return null;
        }

        private boolean isNumber(String str){
            try{
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException ignored){
            }
            return false;
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