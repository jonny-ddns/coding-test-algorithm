package baekjoon_online_judge.solved.q2442_별찍기5;

import java.io.*;

public class Main {
    private final Reader reader = new InputStreamReader(System.in);
    private final Writer writer = new OutputStreamWriter(System.out);
    private final BufferedReader bufferedReader = new BufferedReader(reader);
    private final BufferedWriter bufferedWriter = new BufferedWriter(writer);

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        try{
            bufferedWriter.write(
                solve( Integer.parseInt(bufferedReader.readLine().trim()) ).toString()
            );
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

    private StringBuilder solve(int number) throws IOException {
        int width = width(number);
        int blank = blank(width);

        StringBuilder sb = new StringBuilder();
        int star = 1;
        while(blank >= 0){
            starString(sb, star, blank--);
            star = star + 2;
        }
        return sb;
    }
    private int width(int x){
        return x * 2 - 1;
    }
    private int blank(int x){
        return (x - 1) / 2;
    }
    private void starString(StringBuilder sb, int star, int blank) {
        for (int i = 0; i < blank; i++) {
            sb.append(' ');
        }
        for (int i = 0; i < star; i++) {
            sb.append('*');
        }
        sb.append('\n');
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