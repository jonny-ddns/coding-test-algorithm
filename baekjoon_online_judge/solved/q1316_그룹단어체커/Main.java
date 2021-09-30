package baekjoon_online_judge.solved.q1316_�׷�ܾ�üĿ;

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

        //�����
        private void execute() {
            try{
                int repetition = Integer.parseInt(bufferedReader.readLine().trim());
                int turn = 0;
                int count = 0;
                while (turn < repetition) {
                    if( solve(bufferedReader.readLine().trim()) ){
                        count++;
                    }
                    turn++;
                }
                bufferedWriter.write( Integer.toString(count) );
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
        private boolean solve(String word){
            Collection<Character> Chars = new ArrayList<>();
            char ch;

            for (int i = 0; i < word.length()-1; i++) {
                if (word.charAt(i) == word.charAt(i+1)) {
                    continue;
                }
                ch = word.charAt(i);
                if (!Chars.contains(ch)) {
                    Chars.add(ch);
                    continue;
                }
                return false;
            }
            return !Chars.contains( word.charAt(word.length() - 1) );
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