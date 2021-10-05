package baekjoon_online_judge.unsolved.q2751_�������ϱ�2;

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
//            resourceOpen();
//            execute();
            int t = BSearch(new int[]{1, 3, 5, 7, 8, 9, 12, 20, 33, 44, 55}, 55);
            System.out.println("t = " + t);
        }

        //�����
        private void execute() {
            try{
                int count = Integer.parseInt(bufferedReader.readLine());
                int[] numbers = new int[count];
                int i;
                for (i = 0; i < count; i++) {
                    solve(numbers, i, bufferedReader.readLine().trim());
                }
                for (int number : numbers) {
                    bufferedWriter.write(Integer.toString(number));
                    bufferedWriter.write( "\n" );
                }
                bufferedWriter.flush();
            } catch (IOException ignored){
            } finally {
                try {
                    resourceClose();
                } catch (IOException ignored){
                }
            }
        }
        //
        //���� �ڸ��� > ��
        //����
        //�迭 - ���°�׸� - ��������
        private void solve(int[] numbers, int count, String str){
            int n = Integer.parseInt(str);

            int tmp = count /2;
//            while(){
//
//                if(n < numbers[tmp]){   //�������ڰ� �۴�
//                    tmp = count / 2;    //tmp = 2;
//                } else {
//                    tmp = count / 4 * 3;
//                }
//            }

            
            
            
            for (int i = 0; i <= count; i++) {
                if(n < numbers[i]){
                    numbers[i] = n;
                    break;
                }
                if(i == count){
                    numbers[i] = n;
                }
            }
        }

        int BSearch(int array[], int target) {
            int low = 0;
            int high = array.length - 1;
            int mid;

            while(low <= high) {
                mid = (low + high) / 2;

                if (array[mid] == target)
                    return mid;
                else if (array[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return -1;
        }

        //������ �ε���
        int indexSearch(int array[], int target) {
            int low = 0;
            int high = array.length - 1;
            int mid;

            while(low <= high) {
                mid = (low + high) / 2;

                if (array[mid] == target)
                    return mid;
                else if (array[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return -1;
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