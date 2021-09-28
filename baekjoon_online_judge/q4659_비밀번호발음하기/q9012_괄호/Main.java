package baekjoon_online_judge.q4659_비밀번호발음하기.q9012_괄호;

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
                //입력
                Collection<String> collection = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                String input;
                while( !(input = bufferedReader.readLine().trim()).equals("end") ){
                    solve(collection, sb, input);
                }

                //출력
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

        //연산
        private void solve(Collection<String> collection, StringBuilder sb, String input) {
            boolean result = isContainVowel(input) && isTriple(input) && isDoubleSequence(input);
            makeAnswer(collection, sb, input, result);
        }

        //모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다
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

        //모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다
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

        //같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다
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
        //자원할당
        private void resourceOpen(){
            reader = new InputStreamReader(System.in);
            writer = new OutputStreamWriter(System.out);
            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);
        }

        //자원해제
        private void resourceClose() throws IOException {
            if (reader != null)             reader.close();
            if (writer != null)             writer.close();
            if (bufferedReader != null)     bufferedReader.close();
            if (bufferedWriter != null)     bufferedWriter.close();
        }
    }
}