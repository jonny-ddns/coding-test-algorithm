package baekjoon_online_judge.unsolved.q2108_�����;

/*
���� ó���ϴ� ���� ����п��� ����� �߿��� ���̴�. ����п��� N���� ���� ��ǥ�ϴ� �⺻ ��谪���� ������ ���� �͵��� �ִ�. ��, N�� Ȧ����� ��������.

    ������ : N���� ������ ���� N���� ���� ��
    �߾Ӱ� : N���� ������ �����ϴ� ������ �������� ��� �� �߾ӿ� ��ġ�ϴ� ��
    �ֺ� : N���� ���� �� ���� ���� ��Ÿ���� ��
    ���� : N���� ���� �� �ִ񰪰� �ּڰ��� ����

N���� ���� �־����� ��, �� ���� �⺻ ��谪�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
�Է�

ù° �ٿ� ���� ���� N(1 �� N �� 500,000)�� �־�����. ��, N�� Ȧ���̴�. �� ���� N���� �ٿ��� �������� �־�����. �ԷµǴ� ������ ������ 4,000�� ���� �ʴ´�.
���

ù° �ٿ��� �������� ����Ѵ�. �Ҽ��� ���� ù° �ڸ����� �ݿø��� ���� ����Ѵ�.

��° �ٿ��� �߾Ӱ��� ����Ѵ�.

��° �ٿ��� �ֺ��� ����Ѵ�. ���� �� ���� ������ �ֺ� �� �� ��°�� ���� ���� ����Ѵ�.

��° �ٿ��� ������ ����Ѵ�.

 */
import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
            int[] array = new int[]{1, 2, 4, 5, 6, 7, 7, 4, 1, 6, 2, 5, 7, 2, 6};
            int get = common(array, array.length);
            System.out.println(get);
        }

        //�����
        private void execute() {
            try{
                //count �� 50�� �̸�
                int count = Integer.parseInt(bufferedReader.readLine().trim());
                int[] input = new int[count];
                int turn = 0;
                while (turn < count) {
                    input[turn++] = Integer.parseInt(bufferedReader.readLine().trim());
                }
                bufferedWriter.write( solve(input, count) );
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
        private String solve(int[] input, int count) {
            int[] numbers = sort(input);
            double avg = avg(numbers);
            int middle = middle(numbers, count);
            int common = common(numbers, count);
            int range = range(numbers, count);

            System.out.println("avg = " + avg);
            System.out.println("mid = " + middle);
            System.out.println("com = " + common);
            System.out.println("ran = " + range);

            return null;
        }

        public int[] sort(int[] intArr){
            int i;
            int j;
            int value;
            for(i=1; i< intArr.length; i++){
                j = i-1;
                value = intArr[i];
                while(j >= 0 && value < intArr[j]){
                    intArr[j+1] = intArr[j];
                    j--;
                }
                intArr[j+1] = value;
            }
            return intArr;
        }

        //������
        private double avg(int[] numbers){
            double sum = 0;
            double count = numbers.length;
            for (int number : numbers) {
                sum += number;
            }
            return sum / count;
        }

        //�߾Ӱ�
        private int middle(int[] numbers, int count){
            return numbers[count / 2 + 1];
        }


        //�ֺ�
        private int common(int[] numbers, int count){
            Map<Integer, Integer> map = new HashMap<>();
            int maxCommon = 0;
            int mapValue;

            for (int i : numbers) {
                if (map.containsKey(i)) {
                    mapValue = map.get(i) + 1;
                    map.put(i, mapValue);
                    if(maxCommon < mapValue){
                        maxCommon = mapValue;
                    }
                } else {
                    map.put(i, 1);
                }
            }

            int finalMaxCommon = maxCommon;
            long countValue = map.values().stream().filter(a -> a == finalMaxCommon).count();



            if(countValue == 1){
                for (Integer number : map.keySet()) {
                    if(map.get(number) == maxCommon){
                        return number;
                    }
                }
            }





                    

//            int[] check = new int[numbers[count-1]];
//            for (int i : numbers) {
//                check[i]++;
//            }
//
//            int common = 0;
//            int max = 0;
//            int doubleCommon = 1;
//            for (int i = 0; i < count; i++) {
//                if (max <= i) {
//                    if (max == i) {
//                        doubleCommon++;
//                    } else {
//                        doubleCommon = 0;
//                    }
//                    max = i;
//                }
//            }
//
//            int index;
//            for (int i = 0; i < count; i++) {
//                if (numbers[i] == max) {
//                    common = i;
//                    break;
//                }
//            }
//
//            //�ι�°�� ���� �� ã��
//            if(doubleCommon != 0){
//                for (int i = common + 1; i < count; i++) {
//                    if (numbers[i] == max) {
//                        common = i;
//                        break;
//
//                    }
//                }
//            }
//            return common;
            return 0;
        }

        //����
        private int range(int[] numbers, int count){
            return numbers[count - 1] - numbers[0];
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