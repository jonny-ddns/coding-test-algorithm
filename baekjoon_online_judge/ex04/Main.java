package baekjoon_online_judge.ex04;

/*
0��
1ȣ 2ȣ 3ȣ 4ȣ 5ȣ ...
1   2   3   4   5 ...

1��
1�� 1ȣ
1�� 2ȣ -> 1+2
1�� 3ȣ -> 1+ 2+ 3
1�� ; 1 3 6 10 15
2�� ; 1 4 10 20 35
3�� ; 1 5 15 35 70
4�� ; 1 6 21

��͸� ���� ���� ���� Ŀ����...
ȣ�� ���� ����

a���� bȣ�� ����� �ڽ��� �Ʒ�(a-1)���� 1ȣ���� bȣ���� ������� ���� �ո�ŭ
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

        //k �� - N ȣ
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