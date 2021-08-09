package unsolved.lv01_이상한_문자_만들기;

class Solution {
    public String solution(String s) {
    	String[] strArr = s.toUpperCase().split("");

    	for(int i=0; i<strArr.length-1; i++) {    	
    			strArr[i+1] = strArr[i+1].toLowerCase();
    		i++;
    	}
    	String answer = "";
    	for(String st : strArr) {
    		answer += st;
    	}
    	return answer;
    }
}