package level01.약수의합;
//2021.05.28
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=0; i<n/2; i++) {
        	if(n%(i+1) ==0) {
        		answer += (i+1);
          	}
        }        
        answer = answer+n;        
        return answer;
    }
}