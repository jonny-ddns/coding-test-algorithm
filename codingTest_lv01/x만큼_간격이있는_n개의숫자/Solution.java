package level01.x만큼_간격이있는_n개의숫자;
//2021.06.04
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];       
        long k = x;
        for(int i=0;i<n;i++) {
        	answer[i] = k;
        	k += x;
        }        
        return answer;
    }
}