package codingGame.example.part02.p01_stock_exchange_losses;

import java.io.*;

public class Test {
    private final Reader reader = new InputStreamReader(System.in);
    private final Writer writer = new OutputStreamWriter(System.out);
    private final BufferedReader bufferedReader = new BufferedReader(reader);
    private final BufferedWriter bufferedWriter = new BufferedWriter(writer);

    public static void main(String[] args) {
        new Test().start();
    }

    private void start() {
        try {
            execute();
        } catch (IOException ignored){
        }
    }

    private void execute() throws IOException {
        int count = Integer.parseInt(bufferedReader.readLine().trim());
        String[] input = bufferedReader.readLine().trim().split(" ");
        bufferedWriter.write(Integer.toString(solve(count, input)));
        resourceClose();
    }

    private int solve(int count, String[] input) {
        int[] numbers = intArray(count, input);

        return 0;
    }

    private int[] intArray(int count, String[] input){
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
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
