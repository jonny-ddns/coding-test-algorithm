package baekjoon_online_judge.q4344_������Ѱ���;

import java.io.*;
import java.text.DecimalFormat;

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

        //����� ����
        private void execute() {
            try{
                String[] score;
                int turn = 0;
                int repetition = Integer.parseInt(bufferedReader.readLine());
                while (turn < repetition) {
                    score = bufferedReader.readLine().split(" ");
                    bufferedWriter.write(calculate(score));
                    bufferedWriter.write("\n");
                    turn++;
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

        //����
        private String calculate(String[] input) {
            int[] scores = changeToIntArr(input);
            int sum = 0;
            int i;
            for (i = 1; i < input.length; i++) {
                sum += Integer.parseInt(input[i]);
            }
            double count = scores[0];
            double studentPercent = getStudentPercent(scores, sum / count);
            return printFormat(getRound(studentPercent));
        }

        //int[] ��ȯ
        private int[] changeToIntArr(String[] S){
            int[] I = new int[S.length];
            int i;
            for (i = 0; i < S.length; i++) {
                I[i] = Integer.parseInt(S[i]);
            }
            return I;
        }

        //�л� ���� ���ϱ�
        private double getStudentPercent(int[] scores, double avg){
            if (isAllSameScore(scores, avg)){
                return 100;
            }

            double count = 0;
            int i;
            for (i = 1; i < scores.length; i++) {
                if (avg < scores[i]) {
                    count++;
                }
            }
            return count / (scores.length - 1) * 100;
        }

        //��� ���� �������� Ȯ���ϱ�
        private boolean isAllSameScore(int[] scores, double avg){
            if(avg == 0){
                return false;
            }

            int i;
            for(i = 1; i<scores.length; i++){
                if(scores[i] != avg){
                    return false;
                }
            }
            return true;
        }

        //�ݿø��ϱ�
        private double getRound(double studentPercent){
            double roundRate = Math.pow(10, 3);
            return Math.round(studentPercent * roundRate) / roundRate;
        }

        //��� ����
        private String printFormat(double number) {
            DecimalFormat decimalFormat = new DecimalFormat("0.000");
            return decimalFormat.format(number) + "%";
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