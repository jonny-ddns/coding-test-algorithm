package baekjoon_online_judge.q1181_�ܾ�����;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
//            sortASC();
//            resourceOpen();
//            execute();
            String[] df = new String[]{"a", "dd", "dz", "ab", "def", "abc"};

//            sort(df);
            sortASC(df);
            for (String s : df) {
                System.out.print(s + " ");
            }


        }

        //�����
        private void execute() {
            try{
                int count = Integer.parseInt(bufferedReader.readLine());
                String[] inputs = new String[count];
                int turn = 0;

                while(turn < count){
                    inputs[turn++] = bufferedReader.readLine();
                }
                String[] result = calculate(inputs);
                for (String s : result) {
                    bufferedWriter.write(s);
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

        //����
        private String[] calculate(String[] inputs){
            inputs = filterSet(inputs);
            String[] result = new String[inputs.length];




            return result;
        }
        
        //�ԾƳ���
        private String[] filterSet(String[] inputs){
            Set<String> set = new HashSet<>(Arrays.asList(inputs));
            return (String[]) set.toArray();
        }

        //���� ���� ���ڳ��� �����ϱ� -> [][] �� �����
        private String[][] sortSameLength(String[] a){
            String[][] result = new String[][]{};
            int i, j, targetLength;
            String target;
            for(i = 1; i < a.length; i++) {
                target = a[i];
                targetLength = target.length();
                j = i - 1;
                while(j >= 0 && targetLength < a[j].length()) {
                    a[j + 1] = a[j];	// ���� ���Ҹ� �� ĭ�� �ڷ� �̷��.
                    j--;
                }
                a[j + 1] = target;
            }
            return null;
        }

        //�������� -> �׷� �����ϱ�
        private void sortASC(String[] a){
            String[] change;
//            int max = a[a.length-1].length();
            int count = 0;

            int i;
            for (i=0;i<a.length-1; i++) {
                //���̰� �ٸ���
                if( !(a[i].length() == a[i+1].length()) ){
                    if(count != 0){
//                        change = new String[];
//                        change[0] =
//                        System.out.println(a[i]);
                    }
//                    System.out.println(i + "���̰� �޶��");
//                    System.out.println("count = "+ count);
                    count = 0;
                    continue;
                }
                count++;
                System.out.println(i + "���̰� ���ƿ�");
                System.out.println("count = "+ count);
            }
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