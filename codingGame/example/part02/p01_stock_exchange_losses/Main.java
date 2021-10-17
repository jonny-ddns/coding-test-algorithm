package codingGame.example.part02.p01_stock_exchange_losses;

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
        String input = bufferedReader.readLine().trim();
        bufferedWriter.write(solve(input));
        resourceClose();
    }

    private String solve(String input) {
        return "Hello World!";
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