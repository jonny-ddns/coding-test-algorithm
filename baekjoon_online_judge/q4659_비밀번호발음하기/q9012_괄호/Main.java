package baekjoon_online_judge.q4659_��й�ȣ�����ϱ�.q9012_��ȣ;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

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

        private void execute() {
            try{
                //�Է�
                Collection<String> collection = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                String input;
                while( !(input = bufferedReader.readLine().trim()).equals("end") ){
                    solve(collection, sb, input);
                }

                //���
                for (String s: collection) {
                    bufferedWriter.write(s);
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
        private void solve(Collection<String> collection, StringBuilder sb, String input) {
            boolean result = isContainVowel(input) && isTriple(input) && isDoubleSequence(input);
            makeAnswer(collection, sb, input, result);
        }

        //����(a,e,i,o,u) �ϳ��� �ݵ�� �����Ͽ��� �Ѵ�
        private boolean isContainVowel(String input){
            String sub;
            for (int i = 0; i < input.length(); i++) {
                sub = input.substring(i, i + 1);
                if(sub.equals("a") || sub.equals("e") || sub.equals("i") || sub.equals("o") || sub.equals("u")){
                    return true;
                }
            }
            return false;
        }

        //������ 3�� Ȥ�� ������ 3�� �������� ���� �� �ȴ�
        private boolean isTriple(String input){
            int countConsonant = 0;
            int countVowel = 0;
            String sub;
            for (int i = 0; i < input.length(); i++) {
                sub = input.substring(i, i + 1);
                if(sub.equals("a") || sub.equals("e") || sub.equals("i") || sub.equals("o") || sub.equals("u")){
                    countVowel++;
                    countConsonant = 0;
                } else {
                    countConsonant++;
                    countVowel = 0;
                }
                if(2 < countConsonant || 2 < countVowel){
                    return false;

                }
            }
            return true;
        }

        //���� ���ڰ� ���������� �ι� ���� �ȵǳ�, ee �� oo�� ����Ѵ�
        private boolean isDoubleSequence(String input){
            String sub;
            for (int i = 0; i < input.length()-1; i++) {
                sub = input.substring(i, i + 1);
                if( !(sub.equals("e") || sub.equals("o")) && sub.equals(input.substring(i + 1, i + 2)) ){
                    return false;
                }
            }
            return true;
        }

        private void makeAnswer(Collection<String> collection, StringBuilder sb, String input, boolean result){
            sb.append("<")
                .append(input)
                .append("> is ");
            if(!result){
                sb.append("not ");
            }
            sb.append("acceptable.")
                .append("\n");
            collection.add(sb.toString());
            sb.setLength(0);
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