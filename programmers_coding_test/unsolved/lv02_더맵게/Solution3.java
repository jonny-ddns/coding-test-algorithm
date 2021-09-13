package programmers_coding_test.unsolved.lv02_더맵게;

import java.util.Arrays;

public class Solution3 {
    public int solution(int[] scoville, int K) {
        //정렬하기
        Arrays.sort(scoville);
        int count = 0;

        while(scoville[0]<K) {
            scoville = getNewScovillArray(scoville);
            count++;
            if( scoville.length<2 ){
                if( scoville[0]<K ){
                    count = -1;
                }
                break;
            }
        }
        return count;
    }

    //새로운 스코빌 배열 생성하기
    private int[] getNewScovillArray(int[] scoville){
        int newNumber = getNewNumber(getFirstSecondElement(scoville));
        int[] newScovillArray = getNewArray(scoville, newNumber);
        return newScovillArray;
    }

    //리스트 첫번째 항목 리턴하고 삭제하기
    private int[] getFirstSecondElement(int[] scoville){
        int[] intArr = new int[2];
        intArr[0] = scoville[0];
        intArr[1] = scoville[1];
        return intArr;
    }

    //두개 섞어서 새로운 스코빌 지수 생성하기
    private int getNewNumber(int[] intArr){
        return intArr[0] + intArr[1]*2;
    }

    //새로운 값을 리스트에 넣기
    private int[] getNewArray(int[] scoville, int newNumber){

        int arrayLength = scoville.length;
        int[] scoville_new = new int[arrayLength-1];

        //반복 돌면서 비교하고 값 넣기
        //길이 3까지만 유효함
        for(int i=2; i<scoville.length; i++){
            scoville_new[i-2] = scoville[i];
        }
        scoville_new[arrayLength-2] = newNumber;
        Arrays.sort(scoville_new);

        return scoville_new;
    }
}
