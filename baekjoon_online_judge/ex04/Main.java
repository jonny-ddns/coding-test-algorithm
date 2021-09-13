package baekjoon_online_judge.ex04;

/*
0층
1호 2호 3호 4호 5호 ...
1   2   3   4   5 ...

1층
1층 1호
1층 2호 -> 1+2
1층 3호 -> 1+ 2+ 3
1층 ; 1 3 6 10 15
2층 ; 1 4 10 20 35
3층 ; 1 5 15 35 70
4층 ; 1 6 21

재귀를 쓰면 값이 아주 커진다...
호출 스택 문제

a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Nested().execute();
    }
    static class Nested {
        void execute(){
            Scanner scanner = new Scanner(System.in);
            int testCaseCount = scanner.nextInt();

            int i;
            int result;
            int[] resultArr = new int[testCaseCount];
            for(i=0; i<testCaseCount; i++){
                result = getResidence(scanner);
                resultArr[i] = result;
            }
            printResult(resultArr);

        }

        int getResidence(Scanner scanner){
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            return calculateResidence(k, n);
        }

        //k 층 - N 호
        private int calculateResidence(int k, int n) {
//            int[] floor0 =
//
//
//            int[] floorK =
            return 0;
        }

        void printResult(int[] intArr){
            for (int i : intArr) {
                System.out.println(i);
            }
        }
    }
}