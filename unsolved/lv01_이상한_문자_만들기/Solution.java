package unsolved.lv01_�̻���_����_�����;

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