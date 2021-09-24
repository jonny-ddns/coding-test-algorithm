package baekjoon_online_judge.q1654_랜선자르기;
//랜선 자르기
//https://www.acmicpc.net/problem/1654
import java.io.*;

public class Main {
    public static void main(String[] args) {
        new Solution();
    }

    static class Solution {
        private Reader reader;
        private Writer writer;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;

        private Solution() {
            resourceOpen();
            execute();
        }

        //입출력 수행
        private void execute() {
            try {
                String[] conditions = bufferedReader.readLine().split(" ");
                int count = Integer.parseInt(conditions[0]);
                int lanNeed = Integer.parseInt(conditions[1]);
                int[] lanArray = new int[count];

                int turn = 0;
                while (turn < count){
                    lanArray[turn++] = Integer.parseInt(bufferedReader.readLine());
                }
                int max = resultCalculate(lanArray, lanNeed);

                bufferedWriter.write(Integer.toString(max));
                bufferedWriter.flush();
            } catch (IOException ignored) {
            } finally {
                try {
                    resourceClose();
                } catch (IOException ignored) {
                }
            }
        }

        //값 구하기
        //최대길이 반환하기
        private int resultCalculate(int[] numbers, int need) {
            sort(numbers);
            int have = numbers.length;
            int remainder = need % have;    //나머지 -> 추가할 개수
            int compare = have - remainder;
            int mok = need / have;          //몫 -> 이걸로 나누기
            int result;                     //결과값
//            System.out.println("have = "+ have);
//            System.out.println("need = "+ need);
//            System.out.println("remainder = "+ remainder);
//            System.out.println("compare = "+ compare);
//            System.out.println("mok = "+ mok);
//            System.out.println("first = "+ first);
//            System.out.println("second = "+ second);
            int first = numbers[0] / mok;
            int second = numbers[compare] / ++mok;

            result = first;
            if(first > second){
                result = second;
            }
            return result;
        }

        //정렬하기
        private void sort(int[] intArr){
            int i;
            int j;
            int value;
            for(i=1; i< intArr.length; i++){
                j = i-1;
                value = intArr[i];
                while(j >= 0 && value < intArr[j]){
                    intArr[j+1] = intArr[j];
                    j--;
                }
                intArr[j+1] = value;
            }
        }
        
        //자원할당
        private void resourceOpen(){
            reader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(reader);
            writer = new OutputStreamWriter(System.out);
            bufferedWriter = new BufferedWriter(writer);
        }

        //자원해제
        private void resourceClose() throws IOException {
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}