package baekjoon_online_judge.ex01;

//더하기 사이클
//https://www.acmicpc.net/problem/1110

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Nested().execute();
    }

    static class Nested {
        void execute(){
            Scanner scan = new Scanner(System.in);
            Nested t = new Nested();

            int numOriginal = scan.nextInt();
            int numCompare = numOriginal;
            int count = 0;
            boolean isSame = false;
            while (!isSame){
                System.out.println("while");
                count++;
                int second = t.getSecondNumber(numCompare);
                int x = t.getSecondNumber(numCompare);
                int y = t.getFirstNumber(numCompare);
                int sum = t.sum(x, y);
                System.out.println("sum = "+ sum);

                int numberNew = t.makeNewNumber(second, sum);
                if(numberNew == numOriginal){
                    isSame = true;
                }
                numCompare = numberNew;
                sleepWhile();
            }
            System.out.println("count = "+ count);
        }

        //숫자입력시 두번째값 반환
        private int getSecondNumber(int a){
            return a - (a/10)*10;
        }
        //숫자입력시 첫번째값 반환
        private int getFirstNumber(int a){
            return a - getSecondNumber(a);
        }
        private int sum(int x, int y){

            System.out.println("x+y = "+ (x*y));
            return x * y;
        }

        //두 숫자 합하기
        private int makeNewNumber(int x, int y){
            System.out.println("Test.makeNewNumber");
            String newNumber = intToString(x) + intToString(y);
            System.out.println("newNumber = "+ newNumber);
            return Integer.parseInt(newNumber);
        }

        private String intToString(Integer x){
            return x.toString();
        }
        private void sleepWhile(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored){}
        }
    }
}