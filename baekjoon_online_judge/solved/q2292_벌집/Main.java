package baekjoon_online_judge.solved.q2292_벌집;

import java.io.*;

public class Main {
    private static Reader reader;
    private static Writer writer;
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    public static void main(String[] args) throws IOException {
        resourceOpen();
        {
            int room = Integer.parseInt(bufferedReader.readLine().trim());
            int start = 1;
            int count = 0;
            int calculate;
            while (room - ((calculate = count * 6) + start) > 0) {
                room = room - calculate;
                count++;
            }
            bufferedWriter.write(Integer.toString(++count));
            bufferedWriter.flush();
        }
        resourceClose();
    }

    //자원할당
    private static void resourceOpen(){
        reader = new InputStreamReader(System.in);
        writer = new OutputStreamWriter(System.out);
        bufferedReader = new BufferedReader(reader);
        bufferedWriter = new BufferedWriter(writer);
    }

    //자원해제
    private static void resourceClose() throws IOException {
        if (reader != null)             reader.close();
        if (writer != null)             writer.close();
        if (bufferedReader != null)     bufferedReader.close();
        if (bufferedWriter != null)     bufferedWriter.close();
    }
}