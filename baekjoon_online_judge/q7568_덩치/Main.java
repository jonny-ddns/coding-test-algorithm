package baekjoon_online_judge.q7568_덩치;

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
    /*
4 4 5
5 3 4
3 4 6
5 3 4
2 4
5 6 1
5 6 1
2 9 1


4 4
5 3 2
3 4
6 3 1
2 4
5 6
2 9 1
     */

    private void execute() throws IOException {
        int count = Integer.parseInt(bufferedReader.readLine().trim());
        String[][] input = new String[count][];
        int turn = 0;
        while (turn < count) {
            input[turn++] = bufferedReader.readLine().trim().split(" ");
        }
        bufferedWriter.write(solve(input));
        resourceClose();
    }

    private String solve(String[][] input) {
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