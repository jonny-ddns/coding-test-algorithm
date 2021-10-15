package baekjoon_online_judge.q10868_최솟값;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

            List<Integer> test = Arrays.asList(1, 4, 6);
            for (int i = 0; i < 6; i++) {
                System.out.print(">>삽입시도 = " + i + " | ");
                insert(test, i);
            }
        }

        //입출력
        private void execute() {
            try{
                String[] condition = bufferedReader.readLine().trim().split(" ");
                int count = Integer.parseInt(condition[0]);
                int find = Integer.parseInt(condition[1]);


                List<Integer> list = new LinkedList<>();


                int number;
                for (int i = 0; i < count; i++) {
                    number = Integer.parseInt(bufferedReader.readLine().trim());
                    insert(list, number);
                }

                StringBuilder sb = new StringBuilder();
                String[] input;
                for (int i = 0; i < find; i++) {
                    input = bufferedReader.readLine().trim().split(" ");
                    find(sb, list, input);
                }
                bufferedWriter.write(sb.toString());
                bufferedWriter.flush();
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

        private void insert(List<Integer> list, int number) {
            int index = binarySearch(list, number, 0, list.size());
            //뒤에 있는 항목은 하나씩 뒤로 삽입하기

            System.out.println("index = " + index);

//            for (int i = list.size()-1; i >= index; i--) {
//                int tmp = list.get(i);
//                System.out.println("tmp = " + tmp);
//                list.set(i+1, tmp);
//            }
//            System.out.println("index = " + index);
//            if(list.size() == 0){
//                list.add(index);
//                return;
//            }
//
//
//            //디버깅
//            System.out.println("요소 확인");
//            for (Integer integer : list) {
//                System.out.print(integer + " ");
//
//            }
//            System.out.println(" ");
//            list.set(index, number);
        }

        //7 8
        int binarySearch(List<Integer> list, int target, int start, int end){
            int middle;
            int range = end - start;
            middle = (range / 2) + start;

            System.out.println("middle = " + middle);
            //찾는 값이 작다
//            System.out.println("target = " + target);
//            System.out.println("middle =" + middle);

            //찾는 값이 중간값 보다 작다 -> 앞으로 이동
            if (target < list.get(middle)) {
//                System.out.println("조건 1");
                //원하는 인덱스를 찾음
                if(middle == 0){
                    return 0;
                }
                if(list.get(middle -1) < target){   //4
                    return middle;
                }

//                System.out.println("아니오1");
                return binarySearch(list, target, start, middle - 1);
            }
            
            //찾는 값이 크다
            else {
//                System.out.println("조건 2");
                //원하는 인덱스를 찾음

                if(middle == list.size() -1){
                    return list.size() - 1;
                }
                if(target < list.get(middle + 1)){
                    return middle + 1;
                }
//                System.out.println("아니오2");
                return binarySearch(list, target, middle + 1, end);
            }
        }

        //연산
        private void find(StringBuilder sb, List<Integer> list, String[] find) {
            int tmp = Integer.parseInt(find[0]);
            sb.append(list.get(tmp)).append("\n");
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