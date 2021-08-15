package codingTest_lv01.같은_숫자는_싫어;
//2021.08.15
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        boolean result;
        //앞뒤 값이 다르다면 리스트에 값 추가하기
        for(int i=0; i<arr.length-1; i++){
            result = compareElement(arr, i);
            if(!result){
                list.add(arr[i]);
            }
        }
        //마지막 값 추가
        list.add(arr[arr.length-1]);

        //리스트를 배열로 변환하기
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    //n, n+1 번째 동일여부 판단
    boolean compareElement(int[] arr, int n){
        return (arr[n] == arr[n+1]);
    }
}