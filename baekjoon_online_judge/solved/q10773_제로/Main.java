package baekjoon_online_judge.solved.q10773_제로;

//stack 으로 쉽게 풀 수 있지만 배열을 적용하면
//공간 및 시간을 줄일 수 있음
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
            // 0 이면 count 증가/  다른 숫자, count 가 양수라면 0으로 변동
            // 그리고 합계 계산
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

    //자원해제
    private void resourceClose() throws IOException {
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
        reader.close();
        writer.close();
    }
}