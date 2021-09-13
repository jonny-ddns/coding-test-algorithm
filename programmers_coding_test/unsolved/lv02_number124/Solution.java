package programmers_coding_test.unsolved.lv02_number124;
/*
  -> 변환하기
1   1
2   2
3   4
4   11
5   12
6   14
7   21
8   22
9   24
10  41

3진법으로 먼저 변환하기
 */

import java.util.ArrayList;
import java.util.List;


class Solution {
    public String solution(int n) {
        System.out.println("\n입력숫자 : "+ n);
        String answer = "";
        List<String> list = new ArrayList<>();
        n = n-4;

        list = toTernary(n);

        //124로 변경하기
        for(int i=0; i<list.size(); i++){
            String index = list.get(list.size()-(i+1));
            String result = changeNum(index);
            System.out.println("값 변경 index "+ index+ " | result "+ result);

            answer += result;
        }
        System.out.println("answer : "+ answer);
        return answer;
    }

    List<String> toTernary(int m){
        List<String> list = new ArrayList<>();
        while(m/3 > 0) {
            int k = m%3;
            list.add(String.valueOf(k));
//            System.out.println(k);
            m = m/3;
        }
        list.add(String.valueOf(m%3));
//        System.out.println(m%3);
        return list;

//        System.out.println("3진법 변환 결과"+ list);
    }


    String changeNum(String k){
        String num = "4";
        if(k.equals("0")){
            num = "1";
        } else if(k.equals("1")){
            num = "2";
        }
        return num;
    }
}