package baekjoon_online_judge.q10757_ū��A�÷���B;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution();
    }

    static class Solution {
        private Reader reader;
        private Writer writer;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;

        private Solution() throws IOException{
            resourceOpen();
//            execute();


            for(int i=100000 ;i<200000 ;i++){
                for(int j=9999 ;j<99999 ;j++){
                    String a = Integer.toString(i);
                    String b = Integer.toString(j);
                 bufferedWriter.write( a + " + " + b + " = "+ calculate(new String[]{a, b}));
                 bufferedWriter.write("\n");
                }
                bufferedWriter.flush();
            }

        }

        //����� ����
        private void execute() {
            try{
                String[] numbers = bufferedReader.readLine().split(" ");
                bufferedWriter.write(calculate(numbers));
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
        private String calculate(String[] numbers) {
            String a = numbers[0];
            String b = numbers[1];

            if(a.length() < b.length()){
                String tmp = a;
                a = b;
                b = tmp;
            }

            int[] intArrayA = getReverseIntArray(a);
            int[] intArrayB = getReverseIntArray(b);

            boolean[] ceiling = sum(intArrayA, intArrayB);
            sum_ceiling(intArrayA, ceiling);
            return getNumberString(intArrayA);
        }
        
        //���� ����
        private int[] getReverseIntArray(String s){
            int[] result = new int[s.length() + 1];
            int size = s.length();
            int i;
            for (i = 0; i < size; i++) {
                result[size - i - 1] = Integer.parseInt(s.substring(i, i + 1));
            }
            return result;
        }

        //�迭���� ���ϱ�
        private boolean[] sum(int[] a, int[] b){
            if(a.length < b.length){
                sum(b, a);
            }

            boolean[] ceiling = new boolean[b.length];
            int tmp;
            int i;
            for (i = 0; i < b.length; i++) {
                tmp = a[i] + b[i];
                if(tmp >= 10){
                    tmp -= 10;
                    ceiling[i] = true;
                    a[i] = tmp;
                    continue;
                }
                a[i] = tmp;
                ceiling[i] = false;
            }
            return ceiling;
        }

        //�ø� �� ���ϱ�
        private void sum_ceiling(int[] sum, boolean[] ceiling){
            int i;
            for (i = 0; i < ceiling.length ; i++) {
                if(ceiling[i]){
                    sum[i + 1] = sum[i + 1] + 1;
                }
            }
        }
        
        //����ϱ�
        private String getNumberString(int[] A){
            StringBuilder sb = new StringBuilder();
            int i;
            for (i = A.length - 1; i >= 0; i--) {
                sb.append(A[i]);
            }
            
            String result = sb.toString();
            if(result.indexOf("0") == 0){   //ù���� 0 ���ֱ�
                result = result.replaceFirst("0", "");
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