package level01.x��ŭ_�������ִ�_n���Ǽ���;
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