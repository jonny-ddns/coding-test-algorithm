package baekjoon_online_judge.solved.q10773_����;

//stack ���� ���� Ǯ �� ������ �迭�� �����ϸ�
//���� �� �ð��� ���� �� ����
import java.io.*;

public class Main {
    private final Reader reader = new InputStreamReader(System.in);
    private final Writer writer = new OutputStreamWriter(System.out);
    private final BufferedReader bufferedReader = new BufferedReader(reader);
    private final BufferedWriter bufferedWriter = new BufferedWriter(writer);

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        try {
            execute();
        } catch (IOException ignored){
        }
    }

    private void execute() throws IOException {
        int count = Integer.parseInt(bufferedReader.readLine().trim());
        int[] numbers = new int[count];
        int turn = 0;
        while (turn < count) {
            numbers[turn++] = Integer.parseInt(bufferedReader.readLine().trim());
        }
        bufferedWriter.write(Integer.toString(solve(numbers)));
        resourceClose();
    }

    private int solve(int[] numbers) {
        int x;
        int count = 0;
        int sum = 0;
        int i;
        for (i = numbers.length - 1; i >= 0; i--) {
            x = numbers[i];
            // 0 �̸� count ����/  �ٸ� ����, count �� ������ 0���� ����
            // �׸��� �հ� ���
            if(x == 0){
                count++;
            } else if(count > 0){
                numbers[i] = 0;
                count--;
            } else {
                sum += x;
            }
        }
        return sum;
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