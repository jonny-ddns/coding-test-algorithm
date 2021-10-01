package baekjoon_online_judge.unsolved.q2805_나무자르기;

//나무자르기
//https://www.acmicpc.net/problem/2805
//시간 초과 -> 효율적인 방법 필요(스트림)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Nested().execute();
    }
    static class Nested {
        void execute(){
            Scanner scan = new Scanner(System.in);

            String input1 = scan.nextLine();
            String input2 = scan.nextLine();
            String[] inputArr2 = input2.split(" ");
            String[] inputArr1 = input1.split(" ");

            int[] intArr1 = changeStringToInt(inputArr1);
            int limit = intArr1[1];
            int[] intArr2 = changeStringToInt(inputArr2);
            int height = calulateCutHeight(intArr2, limit);

            System.out.println(height);
        }

        private int[] changeStringToInt(String[] strArr){
            int[] intArr = new int[strArr.length];
            for (int i=0; i< strArr.length; i++) {
                intArr[i] = Integer.parseInt(strArr[i]);
            }
            return intArr;
        }
        
        //어떤 길이로 절단할지 리턴
        private int calulateCutHeight(int[] intArr, int limit){
            int height = getMax(intArr);
            int result;
            boolean find = false;
            while(!find){
                result = getCutResult(intArr, --height);
                if(result >= limit){
                    find = true;
                }
            }
            return height;
        }

        private int getMax(int[] intArr){
            int max = intArr[0];
            for (int j : intArr) {
                if (max < j) {
                    max = j;
                }
            }
            return max;
        }

        private int getCutResult(int[] intArr, int cut){
            int sum = 0;
            int cutResult;
            for(int i : intArr){
                cutResult = i - cut;
                if(0 < cutResult){
                    sum += cutResult;
                }
            }
            return sum;
        }
    }
}