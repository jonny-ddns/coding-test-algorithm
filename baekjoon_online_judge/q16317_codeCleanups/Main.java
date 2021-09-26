package baekjoon_online_judge.q16317_codeCleanups;

import java.io.*;
/*
> dirty push
20이 되지 않도록 관리할 것
클리닝은 가급적 적게 실시
가급적이면 늦출수록 좋다

클리닝은 하루의 마지막에 실시됨
클리닝 시 그날 발생한 push 도 해결됨

해가 바뀌게 되면 dirty push 를 남기지 말아야 함

> 입력
    개수 ; 생산된 push 개수
    각각 발생된 날짜

> 출력
    20 미만으로 유지할 수 있는 클리닝 횟수
    
    
> ex
5
1 45 65 84 346
45와 65는 20차이이므로 그 사이에 클리닝

65와 84는 19차이이므로 84일차에 같이 클리닝

 */
/*
1 2 3 4 5 --> 어떻게 할거야?
배열에 각각 0을 넣기
20번 반복 돌리면서
 0 0 0 0 0
 365 번 반복돌리기


1 2 3 4 5 6 7
  1 2 3 4 5 6 7
    1 2 3 4 5 6

    발생한 날짜 + n번째 날 -> sum1
    발생한 날짜 + n번째 날 -> sum2


  모든 sum 을 더하면 total 이 나온다
  total 20을 넘지 않도록 관리하기
  그럼 몇번 클리닝을 해줘야 되는 거니?
-->

 날짜 3 5 7 이렇게 있다면 1번 이자나 왜?
 365 돌리기
 3 일째

 */
/*
 1 2 3 4 5
 o o x x o

 0 1 1 1 1 1
   0 1 1 1 1
           1
           
           
           
1 2 3 4 5 6
o o o o o
  1 1 1 1 1
    1 1 1 1
      1 1 1
        1 1
        
증가율
1일차 0 누적 0
2일차 1 누적 1 왜나면 전날 누적 0 + 1
3일차 2 누적 3 왜나면 전날 누적 1 + 2
4일차 3 누적 6 왜나면 전날 누적 3 + 3
5일차 4 누적 10왜나면 전날 누적 6 + 4

n 일차는 그 전날 n-1 누적 + 증가율이다
           
 */
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
            try{
                int index = Integer.parseInt(bufferedReader.readLine());
                String[] input = bufferedReader.readLine().split(" ");
                bufferedWriter.write(Integer.toString(calculate(input, index)));
                bufferedWriter.flush();
            } catch (IOException ignored){
            } finally {
                try {
                    resourceClose();
                } catch (IOException ignored){
                }
            }
        }

        //연산
        //2 4 8 11 이라면
        //2일차 4일차 8일차 11일차 그리고 365일차 계산해봐
        //2일차 0
        //4일차
        private int calculate(String[] input, int index) {
            int[] numbers = toIntArray(input, index);

            int dirtyPush = 0;  //누적개수
            int increase = 0;   //증가율
            int cleaning = 0;   //클리닝 횟수

            //중요한 것은 횟수를 세는 것이다
            //반복돌리기
            int date = 0;   //날짜
            while (date < 365){
                date++;
                /*
                만약 1일차에 더티가 생긴다
                그럼 1일차는 더티0 2일차에 더티1이다
                 */
                //날짜
                /*
                날짜 0부터 시작...?
                 */
                //일단 클리닝 안했을때 더티 세기
                //더티가 1개면 1씩 증가 2개면 2씩 증가 n개면 n씩 증가
                //더티가 발생한 날짜부터
//                dirtyPush = 0;
                //더티 날짜인가
                for (int number : numbers) {
                    //더티 발생 -> 증가율 높이기
                    if (20 <= dirtyPush) {
                        System.out.println("클리닝 실시");
                        dirtyPush = 0;
                        increase = 0;
                        cleaning++;
                    }
                    if (number == date - 1) { //더티가 나오는 날인가?
                        System.out.println("더티 발견. 증가율 높이기");
                        increase++;
                    }
                }
                if(date == 365 && dirtyPush != 0){
                    cleaning++;
                }

                dirtyPush += increase;
                System.out.println("date = "+ date + " | dirtyPush = " + dirtyPush + " | increase = "+ increase);
            }
            return cleaning;
        }

        //int[] 변환
        private int[] toIntArray(String[] input, int count){
            int[] result = new int[count];
            int i;
            for(i=0;i<count;i++){
                result[i] = Integer.parseInt(input[i]);
            }
            return result;
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
