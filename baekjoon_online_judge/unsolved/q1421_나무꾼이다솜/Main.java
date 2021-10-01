package baekjoon_online_judge.unsolved.q1421_나무꾼이다솜;

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
                String[] input = bufferedReader.readLine().split(" ");
                int count = Integer.parseInt(input[0]);
                int cost = Integer.parseInt(input[1]);
                int profit = Integer.parseInt(input[2]);
                String[] trees = new String[count];

                int turn = 0;
                while(turn < count){
                    trees[turn++] = bufferedReader.readLine().trim();
                }
                bufferedWriter.write(
                        Integer.toString(calculate(trees, cost, profit))
                );
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
        private int calculate(String[] input, int cost, int profit){
            int[] trees = intArray(input);
            int max = max(trees);

            int[] profitBook = new int[max];
            for (int i = 1; i <= max; i++) {
                profitBook[i-1] = makeProfit(trees, i, cost, profit);
            }
            return max(profitBook);
        }

        //int[] 변환
        private int[] intArray(String[] input){
            int[] result = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                result[i] = Integer.parseInt(input[i]);
            }
            return result;
        }

        private int max(int[] input){
            int max = input[0];
            for (int i : input) {
                if(max < i){
                    max = i;
                }
            }
            return max;
        }

        private int makeProfit(int[] trees, int length, int cost, int profit){
            int costCount = 0;  //비용 단위
            int treeCount = 0;  //잘린 나무개수
            int caseCutTreeYes;
            int caseCutTreeNo;

            //나무를 자르는 경우
            int countPossible;
            for (int tree : trees) {
                if(tree < length){
                    continue;
                }
                countPossible = tree / length;
                treeCount += countPossible;
                costCount += countPossible;
                if (tree % length == 0) {
                    costCount--;
                }
            }
            caseCutTreeYes = length * treeCount * profit - costCount * cost;

            //나무를 자르지 않는 경우
            treeCount = 0;
            for (int tree : trees) {
                if(length == tree){
                    treeCount++;
                }
            }
            caseCutTreeNo = length * treeCount * profit;
            return Math.max(caseCutTreeYes, caseCutTreeNo);
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