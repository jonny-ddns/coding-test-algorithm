package codingTest_lv01.크레인_인형뽑기_게임;
//2021.06.16

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Integer> list = new LinkedList<>();
        int number = 0;
        for (int i=0; i<moves.length; i++){
            if((number = getNumberArray(board, moves[i])) != 0){
                list.add(number);
            }
        }
        return list.size() - removeSameNumber(list).size();
    }

    //배열[][]에서 숫자 가져오기
    private int getNumberArray(int[][] board, int index){
        int k = 0;
        for (int i = 0; i<board.length; i++) {
            k = getNumber(board[i], index);
            if(k != 0){
                break;
            }
        }
        return k;
    }

    //배열에서 0인지 확인하고, 0이 아니라면 숫자 가져오기. 가져오고 나서 0으로 변경
    private int getNumber(int[] intArr, int index){
        int number = 0;
        number = intArr[index-1];
        intArr[index-1] = 0;
        return number;
    }

    //list에서 앞뒤로 같은 숫자 없애기
    private List<Integer> removeSameNumber(List<Integer> list){
        for(int i=list.size()-1; i>0; i--){
            if(list.get(i-1) == list.get(i)){
                list.remove(i);
                list.remove(i-1);
            }
        }
        return list;
    }
}