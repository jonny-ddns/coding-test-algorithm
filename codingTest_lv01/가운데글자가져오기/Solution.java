package level01.������ڰ�������;
//2021.05.10
class Solution {
    public String solution(String s) {
        String answer = "";
        
        if(s.length() % 2 != 0) {
        	answer = s.substring(s.length()/2, s.length()/2+1);
        } else {
        	answer = s.substring(s.length()/2-1, s.length()/2+1);
        }       
        return answer;
    }
}