package programmers_coding_test.codingTest_lv01.���ڼ���;
//2021.06.04
class Solution {
    public String solution(int n) {
    	String watermelon = "����";
    	String halfWord = "��";
    	
    	if(n < 400) {
            String answer = "";
            for(int i=0; i<n/2; i++) {
        		answer += watermelon;
        	}
        	if(n%2!=0) {
        		answer += halfWord;
        	}
            return answer;
    	}
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<n/2; i++) {
    		sb.append(watermelon);
    	}
    	if(n%2!=0) {
    		sb.append(halfWord);
    	}       
        return sb.toString();
    }
}