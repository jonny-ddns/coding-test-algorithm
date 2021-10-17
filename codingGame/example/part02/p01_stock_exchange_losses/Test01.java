package codingGame.example.part02.p01_stock_exchange_losses;

import java.io.*;
/*
6
3 2 4 2 1 5
-3

6
5 3 4 2 3 1
-4

5
1 2 4 4 5
0
 */

public class Test01 {
    private final Reader reader = new InputStreamReader(System.in);
    private final Writer writer = new OutputStreamWriter(System.out);
    private final BufferedReader bufferedReader = new BufferedReader(reader);
    private final BufferedWriter bufferedWriter = new BufferedWriter(writer);

    public static void main(String[] args) {
        new Test01().start();
    }

    private void start() {
        try {
            execute();
        } catch (IOException ignored){
        }
    }

    //입출력
    private void execute() throws IOException {
        int count       = Integer.parseInt(bufferedReader.readLine().trim());
        String[] input  = bufferedReader.readLine().trim().split(" ");
        bufferedWriter.write(Integer.toString(solve(count, input)));
        resourceClose();
    }

    //풀이
    private int solve(int count, String[] input) {
        int[] numbers = intArray(count, input);
        return min(numbers);
    }

    private int[] intArray(int count, String[] input){
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }

    private int min(int[] numbers) {
        int now;
        int loss;
        int highest = 0;
        int record = 0;
        int i;
        for (i = 0; i < numbers.length; i++) {
            now = numbers[i];
            if(highest < now){
                highest = now;
            }
            loss = now - highest;
            if(Math.abs(record) < Math.abs(loss)){
                record = loss;
            }
        }
        return record;
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
