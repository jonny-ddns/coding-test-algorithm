package level01.³»Àû;
//2021.05.04
class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int sum = 0;
        
        for(int i=0; i<a.length; i++){
        	sum = a[i]*b[i];
        	answer += sum;
        }        
        return answer;
    }
}