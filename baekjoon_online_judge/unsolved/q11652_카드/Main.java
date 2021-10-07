package baekjoon_online_judge.q11652_카드;

import java.io.*;
import java.util.*;

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

        //입출력
        private void execute() {
            try {
                int count = Integer.parseInt(bufferedReader.readLine().trim());
                long[] numbers = new long[count];
                int turn = 0;
                while (turn < count) {
                    numbers[turn++] = Long.parseLong(bufferedReader.readLine().trim());
                }
                bufferedWriter.write(Long.toString(solve(numbers)));
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
        private long solve(long[] numbers) {
            Map<Long, Integer> map = new HashMap<>();
            int value;
            int maxValue = 0;
            int maxCount = 0;

            //map - put
            for (long i : numbers) {
                if(!map.containsKey(i)){
                    map.put(i, 1);
                } else {
                    value = map.get(i) + 1;
                    map.replace(i, value);

                    if(maxValue == value){
                        maxCount++;
                        continue;
                    }
                    if(maxValue < value){
                        maxValue = value;
                        maxCount = 1;
                    }
                }
            }

            //가장 많은 항목의 개수가 1
            if (maxCount == 1) {
                for (Long index : map.keySet()) {
                    if(map.get(index) == maxValue){
                        return index;
                    }
                }
            }
            
            //가장 많은 개수가 2 이상
            Collection<Long> colKey = new ArrayList<>();
            for (Long i : map.keySet()) {
                if(map.get(i) == maxValue){
                    colKey.add(i);
                }
            }
            if(colKey.size() != 0){
                return Collections.min(colKey);
            }

            //모두 1개씩만 있는 경우
            return Collections.min(new ArrayList<>(map.values()));
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