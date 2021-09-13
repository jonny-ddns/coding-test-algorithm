package programmers_coding_test.unsolved.lv02_문자열압축;

//https://programmers.co.kr/learn/courses/30/lessons/60057?language=java

/*
문자열은 제일 앞부터 정해진 길이만큼 잘라야 한다
-중간부터 자르는 것 비허용
문자열 특정 숫자기준으로만 압축하기
리턴값; 압축된 최소길이
 */
/*
반복문 돌면서 줄일 수 있는지 찾기
반복문의 반복자는 2부터 주어진 문자열의 1/2까지

문자열과 숫자가 주어진다
문자열의 처음부터 숫자만큼 길이를 잘라본다 ->
자른 문자열만큼 개수 일치하는 개수 확인하기
문자열 바꾸기 -> 개수+문자열+나머지

각 문자열별로 길이 세기
최솟값을 리턴하기
 */
class Solution {
    public int solution(String body) {
        int answer = 0;
        String piece;
        int i;
        int count;
        int min;

        for(i=2; i<body.length()/2+1; i++){
            piece = getPiece(body, i);
            count = test2(body, piece);
            System.out.println("piece : "+ piece);



//            count = test2(body, piece);
            System.out.println("count : "+ count);

        }
        return answer;
    }

    //문자열 찾기
    //특정 숫자 -> 숫자에 해당하는 길이 토막 찾기
    //when 2 -->
//    String test(String body, int num){
//        String compare = getPiece(body, num);
//        String part;
//
//        int count = 0;
//        boolean isEqual = true;
//        part = body.substring(i*num, num);
//        while(isEqual){
//            for(int i=0; i<body.length(); i++){
//
//                if(!compare.equals(part)){
//                    break;
//                }
//                count++;
//            }
//        }
//        body.replace()
//                //+count;
//        return body;
//    }

    //일치하는 것까지 문자열 반환하기
    String test3(String body, String part){
        int num = part.length();

        //조건문

        for(int i=0; num*i<body.length(); i++){
//            if(){
//
//
//                continue;
//            }
            break;
        }

        return null;
    }


    void test2(String body, int num){
        String compare = getPiece(body, num);   //비교할 문자열
//        String part;


        
    }




    //개수에 따라 문자열 토막 만들기
    String getPiece(String body, int num){
        return body.substring(0, num);
    }
    
    //문자열 바꾸기
    int test2(String body, String part){
        return (body.replace(part, "")+ part).length();
    }
}