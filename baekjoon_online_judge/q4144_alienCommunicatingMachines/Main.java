package baekjoon_online_judge.q4144_alienCommunicatingMachines;

import java.io.*;

/*
����
x y z
x ����
y ����
z -> x �������� ������ -> y �������� ����Ͻÿ�
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

        //����� ����
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

        //����
        private String solve(String[] input) {
            int x = Integer.parseInt(input[0]); //����
            int y = Integer.parseInt(input[1]); //����
            String z = input[2];            //��ȯ�ϱ�
            int decimalX = getX(x, z);      //10�������� ������
            return setY(y, decimalX);
        }

        //������ȯ. x���� -> 10����
        private int getX(int x, String z){
            int number;
            int count = 0;
            int sum = 0;
            for (int i = z.length() -1; i>=0 ; i--) {
                number = changeUnit_alienToDecimal(z.substring(i, i + 1));  //������
                sum += number * Math.pow(x, count++);
            }
            return sum;
        }

        //������ȯ. 10���� -> y����
        /*
        ���� ��ȯ�ϱ�
        10���� 7�� 2�������� �ٲٷ���
             7�� 2�� ��� ������
             1�� ���� ������
             7 �������� ��� ���ϸ� ��
         */
        private String setY(int y, int decimalX){
            String number = Integer.toString(decimalX);
            int count = 0;
            int multiply;

            int tmp = decimalX;

            while(true){
                int remain = tmp % y;   //������
                int mok = tmp / y; //��
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
        
        //2���� ��ȯ Ȯ��
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
        

        //���� ��ȯ. 10��������
        private int changeUnit_alienToDecimal(String subZ){
            if(isNumber(subZ)){
                return Integer.parseInt(subZ);
            }
            return subZ.getBytes()[0] - 54;
        }

        //���� ��ȯ. y ��������
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