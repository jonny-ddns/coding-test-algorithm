package programmers_coding_test.lv02_42746;

/*
    30
    301
    302
    32

    3234567
     */
    /*

    9
    91
    92
    ...

    99
    991
    992
    990
    999

    9
    98
    980
    989

    9 989 98 980
    9 98 989 980

    8
    79
    77
    76
    6
    999
    9997

    잘 모르면 후보에 넣기
    how
    9999 99 999
    9999 99 999

    329
    3291
    3293
    3294
     */
class Solution {


    public String solution(int[] numbers) {
        String answer = "";
        return answer;
    }

    int[] test(int[] numbers){
        int n;
        //첫자리 구하기
        for (int i = 9; i > 0; i--) {
            for (int number : numbers) {
                n = number;
            }
        }
        return null;

    }


    //자릿수 구하기
    int position(int x){
        for (int i = 7; i >= 0; i--) {
            if(x >= Math.pow(10, i)){
                return i;
            }
        }
        return 0;
    }
}