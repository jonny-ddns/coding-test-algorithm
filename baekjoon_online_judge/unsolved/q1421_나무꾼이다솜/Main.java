package baekjoon_online_judge.unsolved.q1421_�������̴ټ�;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        new Solution();
    }

    //��øŬ����
    static class Solution {
        private Reader reader;
        private Writer writer;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;

        private Solution() {
            resourceOpen();
            execute();
        }

        //�����
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

        //����
        private int calculate(String[] input, int cost, int profit){
            int[] trees = intArray(input);
            int max = max(trees);

            int[] profitBook = new int[max];
            for (int i = 1; i <= max; i++) {
                profitBook[i-1] = makeProfit(trees, i, cost, profit);
            }
            return max(profitBook);
        }

        //int[] ��ȯ
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
            int costCount = 0;  //��� ����
            int treeCount = 0;  //�߸� ��������
            int caseCutTreeYes;
            int caseCutTreeNo;

            //������ �ڸ��� ���
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

            //������ �ڸ��� �ʴ� ���
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
        //�ڿ��Ҵ�
        private void resourceOpen(){
            reader = new InputStreamReader(System.in);
            writer = new OutputStreamWriter(System.out);
            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);
        }

        //�ڿ�����
        private void resourceClose() throws IOException {
            if (reader != null)             reader.close();
            if (writer != null)             writer.close();
            if (bufferedReader != null)     bufferedReader.close();
            if (bufferedWriter != null)     bufferedWriter.close();
        }
    }
}