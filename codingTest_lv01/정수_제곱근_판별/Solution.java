package codingTest_lv01.정수_제곱근_판별;
//2021.06.04
class Solution {
    public long solution(long n) {
        double squareRootD = Math.sqrt(n);
        int squareRootI = (int) Math.sqrt(n);
        if(squareRootD-squareRootI == 0) {
        	return (long) Math.pow(squareRootI+1, 2);
        }
		return -1;
    }
}