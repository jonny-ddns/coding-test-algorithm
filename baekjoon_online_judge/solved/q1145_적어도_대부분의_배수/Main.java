package baekjoon_online_judge.solved.q1145_���_��κ���_���;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

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
                String[] input = bufferedReader.readLine().split(" ");
                bufferedWriter.write(Integer.toString(calculate(input)));
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
        private int calculate(String[] input) {
            int[] numbers = change(input);
            boolean find = false;
            int compare = 1;
            while(!find){
                if(findCommon(numbers, ++compare)){
                    find = true;
                }
            }
            return compare;
        }

        //int[] ��ȯ
        private int[] change(String[] S){
            int[] result = new int[S.length];
            int i;
            for(i=0; i< S.length; i++){
                result[i] = Integer.parseInt(S[i]);
            }
            return result;
        }

        //����� �Ǵ� ����
        private boolean findCommon(int[] numbers, int a){
            int count = 0;
            for (int number : numbers) {
                if(a%number == 0){
                    count++;
                }
            }
            return count >= 3;
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
