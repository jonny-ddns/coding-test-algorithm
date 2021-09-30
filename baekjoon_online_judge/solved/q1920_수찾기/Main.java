package baekjoon_online_judge.solved.q1920_수찾기;

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
//            resourceOpen();
//            execute();
            String[] str = new String[]{"98", "62", "16", "28"};
            int length = 4;
            int [] in = sort(str, length);
            for (int i : in) {
                System.out.println(i);
            }
        }

        //입출력
        private void execute() {
//            try {
//                int countN = Integer.parseInt(bufferedReader.readLine().trim());
//                int[] array = changeToIntArray(bufferedReader.readLine().split(" "), countN);
//
//                int countM = Integer.parseInt(bufferedReader.readLine());
//                int[] search = changeToIntArray(bufferedReader.readLine().split(" "), countM);
//
//                int[] result = find(sort(array), search);
//                for (int i : result) {
//                    bufferedWriter.write(Integer.toString(i));
//                    bufferedWriter.write("\n");
//                }
//            } catch (IOException io) {
//                io.printStackTrace();
//            } finally {
//                try {
//                    resourceClose();
//                } catch (IOException io) {
//                    io.printStackTrace();
//                }
//            }
        }

        //int[] 변환 + d f
        private int[] changeToIntArray(String[] numbers) {
            int[] result = new int[numbers.length];
            int i;
            for (i = 0; i < result.length; i++) {
                result[i] = Integer.parseInt(numbers[i]);
            }
            return result;
        }

        //int[] 변환 및 삽입정렬
        private int[] sort(String[] array, int length) {
            int[] result = new int[length];
            result[0] = Integer.parseInt(array[0]);

            int i;
            int j;
            int value;
            //가져올 인덱스 i
            for (i = 1; i < array.length; i++) {
                j = i - 1;
                value = result[i];
                while (j >= 0 && value < Integer.parseInt(array[j])) {
                    result[j + 1] = result[j];
                    j--;
                }
                result[j + 1] = value;
            }
            return result;
        }

        //근접값 찾기
        private int[] find(int[] data, int[] search) {
            System.out.println("Main.find");
            int[] result = new int[search.length];
            int i;
            for (i = 0; i < search.length; i++) {
                if (isContain(data, search[i])) {
                    result[i] = 1;
                    continue;
                }
                result[i] = 0;
            }
            return result;
        }

        private boolean isContain(int[] data, int search) {
            int low = 0;
            int high = data.length - 1;
            int mid;

            while (low <= high) {
                mid = (low + high) / 2;

                if (data[mid] == search) {
                    return true;
                } else if (data[mid] > search) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }

        /*-----------------------------------------*/
        //자원할당
        private void resourceOpen() {
            reader = new InputStreamReader(System.in);
            writer = new OutputStreamWriter(System.out);
            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);
        }

        //자원해제
        private void resourceClose() throws IOException {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
        }
    }
}