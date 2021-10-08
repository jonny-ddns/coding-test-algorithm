package baekjoon_online_judge.solved.q2884_�˶��ð�;

import java.io.*;

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

        //�����
        private void execute() {
            try{
                String[] input = bufferedReader.readLine().trim().split(" ");
                bufferedWriter.write( solve(input) );
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
        private String solve(String[] input) {
            int hour = Integer.parseInt(input[0]);
            int minute = Integer.parseInt(input[1]);
            int[] minuteValue = changeMinute(minute);
            int hour2 = changeHour(hour, minuteValue[0]);
            int minute2 = minuteValue[1];
            return hour2 + " " + minute2;
        }

        //�� ��ȯ�ϱ�
        int[] changeMinute(int a){
            int check = 0;
            int minute;
            minute = a - 45;
            if(a < 45){
                check = 1;
                minute = a - 45 + 60;
            }
            return new int[]{check, minute};
        }

        //�� ��ȯ�ϱ�
        int changeHour(int a, int b) {
            int hour = a - b;
            if (hour < 0) {
                hour = hour + 24;
            }
            return hour;
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