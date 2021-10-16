package baekjoon_online_judge.solved.q2941_ũ�ξ�Ƽ��_���ĺ�;

/*
�ش� �ܾ� " " �� �����ϰ�
����� ������ �״�� �����ִ� ������ ������ ���
 */
import java.io.*;

public class Main {
    private final Reader reader = new InputStreamReader(System.in);
    private final Writer writer = new OutputStreamWriter(System.out);
    private final BufferedReader bufferedReader = new BufferedReader(reader);
    private final BufferedWriter bufferedWriter = new BufferedWriter(writer);

    public static void main(String[] args) {
        new Main().start();
    }

    void start() {
        try {
            execute();
        } catch (IOException ignored){
        }
    }

    private void execute() throws IOException {
        try{
            String word = bufferedReader.readLine();
            bufferedWriter.write(Integer.toString(calculate(word)));
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
    private int calculate(String word) {
        String[] words = croatiaWords();
        String find;
        String changed;

        int change = 0;
        int i;
        for (i = 0; i < words.length; i++) {
            find = words[i];
            changed = wordChange(word, find);
            int tmp = blank(word, changed, find);
            change += tmp;
            word = changed;
        }

        int count = 0;
        for (i = 0; i < word.length(); i++) {
            if(word.charAt(i) != ' ') {
                count++;
            }
        }
        return count + change;
    }

    private String[] croatiaWords(){
        return new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    }

    //�ش� �ܾ� ã�� "" �� replace
    private String wordChange(String word, String find){
        String replacement = "  ";
        if(find.length() > 2){
            replacement = "   ";
        }
        while(word.contains(find)){
            word = word.replace(find, replacement);
        }
        return word;
    }

    //blank ���� ã��
    private int blank(String before, String after, String find){
        int i;
        int count_before = 0;
        int count_after = 0;
        for (i = 0; i < before.length() - 1; i++) {
            if (before.charAt(i) == ' ') {
                count_before++;
            }
        }
        for (i = 0; i < after.length(); i++) {
            if (after.charAt(i) == ' ') {
                count_after++;
            }
        }
        return (count_after - count_before) / find.length();
    }

    //�ڿ�����
    private void resourceClose() throws IOException {
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
        reader.close();
        writer.close();
    }
}