package baekjoon_online_judge.q1874_스택수열;

import java.io.*;
import java.util.Arrays;

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
        while(turn < count){
            numbers[turn++] = Integer.parseInt(bufferedReader.readLine().trim());
        }
        StringBuilder sb = new StringBuilder();
        solve(sb, count, numbers);
        bufferedWriter.write(sb.toString());
        resourceClose();
    }

    /*
    1~n까지 스택에 넣기
    넣다가 해당 숫자 나오면 스탑

    현재위치 now
    p p p p
    4
    1 1 1 0 1 1 1 1
    3
    q
    1 1 0 0 1 1 1 1
    5
    p
    1 1 0 0 0 1 1 1
     */
    private void solve(StringBuilder sb, int count, int[] numbers) {
        int[] check = new int[count + 1];
        Arrays.fill(check, 0);

        int now = 0;
        for (int number : numbers) {
            System.out.println("check 확인");
            for (int i : check) {
                System.out.print(i + " ");
            }
            System.out.println("end");
            if(now < number){
                for (int i = now; i <= number; i++) {
                    if (check[i] != -1) {
                        sb.append("+ ");
                        check[i] = 1;
                    }
                }
                sb.append("- ");
            }
            else {
                for (int i = now; i >= number; i--) {
                    if (check[i] != -1) {
                        sb.append("- ");
                        check[i] = 0;
                    }
                    if(i == number && check[i] == -1){
                        System.out.println("stop");
                        sb.setLength(0);
                        sb.append("NO");
                        return;
                    }
                }
            }
            check[number] = -1;
            now = number;

        }
    }

    private void solve_tmp(StringBuilder sb, int count, int[] numbers) {
        int[] check = new int[count + 1];
        Arrays.fill(check, 1);
        check[0] = 0;

        int now = 0;
        for (int number : numbers) {
            System.out.println("now = " + now);
            System.out.println("적용 숫자 = " + number);
            if(now < number){
                for (int i = now; i <= number; i++) {
                    if (check[i] != 0) {
                        sb.append("+ ");
                    }
                }
                sb.append("- ");
            }
            else {
                for (int i = now; i >= number; i--) {
                    if (check[i] != 0) {
                        sb.append("- ");
                    }
                }
            }
            check[number] = 0;
            now = number;
            System.out.println("경로 확인 " + sb.toString());

            System.out.println("check 확인");
            for (int i : check) {
                System.out.print(i + " ");
            }
            System.out.println("end");
        }
    }

    //인덱스 찾기
//    private void find(StringBuilder sb, int[] check, int number, int now){
//        System.out.println("적용할 숫자 = "+ number);
//        if(now < number){
//            for (int i = 0; i < number; i++) {
//                if (check[i] != 0) {
//                    sb.append("+\n");
//                }
//            }
//        }
//        else {
//            for (int i = 0; i < number; i++) {
//                if (check[i] != 0) {
//                    sb.append("-\n");
//                }
//            }
//        }
//        now = number;
//        check[number] = 0;
//    }

    //자원해제
    private void resourceClose() throws IOException {
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
        reader.close();
        writer.close();
    }
}