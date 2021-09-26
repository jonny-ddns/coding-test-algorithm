package baekjoon_online_judge.q16317_codeCleanups;

import java.io.*;
/*
> dirty push
20�� ���� �ʵ��� ������ ��
Ŭ������ ������ ���� �ǽ�
�������̸� ������� ����

Ŭ������ �Ϸ��� �������� �ǽõ�
Ŭ���� �� �׳� �߻��� push �� �ذ��

�ذ� �ٲ�� �Ǹ� dirty push �� ������ ���ƾ� ��

> �Է�
    ���� ; ����� push ����
    ���� �߻��� ��¥

> ���
    20 �̸����� ������ �� �ִ� Ŭ���� Ƚ��
    
    
> ex
5
1 45 65 84 346
45�� 65�� 20�����̹Ƿ� �� ���̿� Ŭ����

65�� 84�� 19�����̹Ƿ� 84������ ���� Ŭ����

 */
/*
1 2 3 4 5 --> ��� �Ұž�?
�迭�� ���� 0�� �ֱ�
20�� �ݺ� �����鼭
 0 0 0 0 0
 365 �� �ݺ�������


1 2 3 4 5 6 7
  1 2 3 4 5 6 7
    1 2 3 4 5 6

    �߻��� ��¥ + n��° �� -> sum1
    �߻��� ��¥ + n��° �� -> sum2


  ��� sum �� ���ϸ� total �� ���´�
  total 20�� ���� �ʵ��� �����ϱ�
  �׷� ��� Ŭ������ ����� �Ǵ� �Ŵ�?
-->

 ��¥ 3 5 7 �̷��� �ִٸ� 1�� ���ڳ� ��?
 365 ������
 3 ��°

 */
/*
 1 2 3 4 5
 o o x x o

 0 1 1 1 1 1
   0 1 1 1 1
           1
           
           
           
1 2 3 4 5 6
o o o o o
  1 1 1 1 1
    1 1 1 1
      1 1 1
        1 1
        
������
1���� 0 ���� 0
2���� 1 ���� 1 �ֳ��� ���� ���� 0 + 1
3���� 2 ���� 3 �ֳ��� ���� ���� 1 + 2
4���� 3 ���� 6 �ֳ��� ���� ���� 3 + 3
5���� 4 ���� 10�ֳ��� ���� ���� 6 + 4

n ������ �� ���� n-1 ���� + �������̴�
           
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
            resourceOpen();
            execute();
        }

        //�����
        private void execute() {
            try{
                int index = Integer.parseInt(bufferedReader.readLine());
                String[] input = bufferedReader.readLine().split(" ");
                bufferedWriter.write(Integer.toString(calculate(input, index)));
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
        //2 4 8 11 �̶��
        //2���� 4���� 8���� 11���� �׸��� 365���� ����غ�
        //2���� 0
        //4����
        private int calculate(String[] input, int index) {
            int[] numbers = toIntArray(input, index);

            int dirtyPush = 0;  //��������
            int increase = 0;   //������
            int cleaning = 0;   //Ŭ���� Ƚ��

            //�߿��� ���� Ƚ���� ���� ���̴�
            //�ݺ�������
            int date = 0;   //��¥
            while (date < 365){
                date++;
                /*
                ���� 1������ ��Ƽ�� �����
                �׷� 1������ ��Ƽ0 2������ ��Ƽ1�̴�
                 */
                //��¥
                /*
                ��¥ 0���� ����...?
                 */
                //�ϴ� Ŭ���� �������� ��Ƽ ����
                //��Ƽ�� 1���� 1�� ���� 2���� 2�� ���� n���� n�� ����
                //��Ƽ�� �߻��� ��¥����
//                dirtyPush = 0;
                //��Ƽ ��¥�ΰ�
                for (int number : numbers) {
                    //��Ƽ �߻� -> ������ ���̱�
                    if (20 <= dirtyPush) {
                        System.out.println("Ŭ���� �ǽ�");
                        dirtyPush = 0;
                        increase = 0;
                        cleaning++;
                    }
                    if (number == date - 1) { //��Ƽ�� ������ ���ΰ�?
                        System.out.println("��Ƽ �߰�. ������ ���̱�");
                        increase++;
                    }
                }
                if(date == 365 && dirtyPush != 0){
                    cleaning++;
                }

                dirtyPush += increase;
                System.out.println("date = "+ date + " | dirtyPush = " + dirtyPush + " | increase = "+ increase);
            }
            return cleaning;
        }

        //int[] ��ȯ
        private int[] toIntArray(String[] input, int count){
            int[] result = new int[count];
            int i;
            for(i=0;i<count;i++){
                result[i] = Integer.parseInt(input[i]);
            }
            return result;
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
