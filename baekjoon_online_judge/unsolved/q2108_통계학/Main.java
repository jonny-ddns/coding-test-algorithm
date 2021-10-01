package baekjoon_online_judge.unsolved.q2108_통계학;

/*
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

    산술평균 : N개의 수들의 합을 N으로 나눈 값
    중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
    최빈값 : N개의 수들 중 가장 많이 나타나는 값
    범위 : N개의 수들 중 최댓값과 최솟값의 차이

N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
입력

첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
출력

첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.

 */
import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
            int[] array = new int[]{1, 2, 4, 5, 6, 7, 7, 4, 1, 6, 2, 5, 7, 2, 6};
            int get = common(array, array.length);
            System.out.println(get);
        }

        //입출력
        private void execute() {
            try{
                //count 는 50만 미만
                int count = Integer.parseInt(bufferedReader.readLine().trim());
                int[] input = new int[count];
                int turn = 0;
                while (turn < count) {
                    input[turn++] = Integer.parseInt(bufferedReader.readLine().trim());
                }
                bufferedWriter.write( solve(input, count) );
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

        //연산
        private String solve(int[] input, int count) {
            int[] numbers = sort(input);
            double avg = avg(numbers);
            int middle = middle(numbers, count);
            int common = common(numbers, count);
            int range = range(numbers, count);

            System.out.println("avg = " + avg);
            System.out.println("mid = " + middle);
            System.out.println("com = " + common);
            System.out.println("ran = " + range);

            return null;
        }

        public int[] sort(int[] intArr){
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
            return intArr;
        }

        //산술평균
        private double avg(int[] numbers){
            double sum = 0;
            double count = numbers.length;
            for (int number : numbers) {
                sum += number;
            }
            return sum / count;
        }

        //중앙값
        private int middle(int[] numbers, int count){
            return numbers[count / 2 + 1];
        }


        //최빈값
        private int common(int[] numbers, int count){
            Map<Integer, Integer> map = new HashMap<>();
            int maxCommon = 0;
            int mapValue;

            for (int i : numbers) {
                if (map.containsKey(i)) {
                    mapValue = map.get(i) + 1;
                    map.put(i, mapValue);
                    if(maxCommon < mapValue){
                        maxCommon = mapValue;
                    }
                } else {
                    map.put(i, 1);
                }
            }

            int finalMaxCommon = maxCommon;
            long countValue = map.values().stream().filter(a -> a == finalMaxCommon).count();



            if(countValue == 1){
                for (Integer number : map.keySet()) {
                    if(map.get(number) == maxCommon){
                        return number;
                    }
                }
            }





                    

//            int[] check = new int[numbers[count-1]];
//            for (int i : numbers) {
//                check[i]++;
//            }
//
//            int common = 0;
//            int max = 0;
//            int doubleCommon = 1;
//            for (int i = 0; i < count; i++) {
//                if (max <= i) {
//                    if (max == i) {
//                        doubleCommon++;
//                    } else {
//                        doubleCommon = 0;
//                    }
//                    max = i;
//                }
//            }
//
//            int index;
//            for (int i = 0; i < count; i++) {
//                if (numbers[i] == max) {
//                    common = i;
//                    break;
//                }
//            }
//
//            //두번째로 작은 값 찾기
//            if(doubleCommon != 0){
//                for (int i = common + 1; i < count; i++) {
//                    if (numbers[i] == max) {
//                        common = i;
//                        break;
//
//                    }
//                }
//            }
//            return common;
            return 0;
        }

        //범위
        private int range(int[] numbers, int count){
            return numbers[count - 1] - numbers[0];
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