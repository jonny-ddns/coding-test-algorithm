package programmers_coding_test.codingTest_lv01.크레인_인형뽑기_게임;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] board = new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = new int[] {1,5,3,5,1,2,1,4};
        int answer = s.solution(board, moves);
        System.out.println(answer);

    }
}
/*
00000
00103
02501
42442
35131
*/
