package baekjoon_online_judge.unsolved.q2751_수정렬하기2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        new Solution();
    }

    //중첩클래스
    static class Solution {
        private Reader reader;
        private Writer writer;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;

        private Solution() {
//            resourceOpen();
//            execute();
            int t = BSearch(new int[]{1, 3, 5, 7, 8, 9, 12, 20, 33, 44, 55}, 55);
            System.out.println("t = " + t);
        }

        //입출력
        private void execute() {
            try{
                int count = Integer.parseInt(bufferedReader.readLine());
                int[] numbers = new int[count];
                int i;
                for (i = 0; i < count; i++) {
                    solve(numbers, i, bufferedReader.readLine().trim());
                }
                for (int number : numbers) {
                    bufferedWriter.write(Integer.toString(number));
                    bufferedWriter.write( "\n" );
                }
                bufferedWriter.flush();
            } catch (IOException ignored){
            } finally {
                try {
                    resourceClose();
                } catch (IOException ignored){
                }
            }
        }
        //
        //절반 자르기 > 비교
        //연산
        //배열 - 몇번째항목 - 넣을숫자
        private void solve(int[] numbers, int count, String str){
            int n = Integer.parseInt(str);

            int tmp = count /2;
//            while(){
//
//                if(n < numbers[tmp]){   //넣을숫자가 작다
//                    tmp = count / 2;    //tmp = 2;
//                } else {
//                    tmp = count / 4 * 3;
//                }
//            }

            
            
            
            for (int i = 0; i <= count; i++) {
                if(n < numbers[i]){
                    numbers[i] = n;
                    break;
                }
                if(i == count){
                    numbers[i] = n;
                }
            }
        }

        int BSearch(int array[], int target) {
            int low = 0;
            int high = array.length - 1;
            int mid;

            while(low <= high) {
                mid = (low + high) / 2;

                if (array[mid] == target)
                    return mid;
                else if (array[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return -1;
        }

        //삽입할 인덱스
        int indexSearch(int array[], int target) {
            int low = 0;
            int high = array.length - 1;
            int mid;

            while(low <= high) {
                mid = (low + high) / 2;

                if (array[mid] == target)
                    return mid;
                else if (array[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return -1;
        }

        /*---------------------------------------------*/
        //자원할당
        private void resourceOpen(){
            reader = new InputStreamReader(System.in);
            writer = new OutputStreamWriter(System.out);
            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);
        }

        //자원해제
        private void resourceClose() throws IOException {
            if (reader != null)             reader.close();
            if (writer != null)             writer.close();
            if (bufferedReader != null)     bufferedReader.close();
            if (bufferedWriter != null)     bufferedWriter.close();
        }
    }
}