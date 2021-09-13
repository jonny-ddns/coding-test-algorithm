package programmers_coding_test.unsolved.lv02_jadenCase_문자열_만들기;

class Solution {
 public String solution(String s) {
    	String[] strArr = new String[s.length()];
        strArr = s.toLowerCase().split("");
        
        //공백 다음 글자 대문자 변환
        for(int i=0; i<strArr.length-1; i++) {
        	if(strArr[i].equals(" ")) {
        		strArr[i+1] = strArr[i+1].toUpperCase();
        	}
        }
        
        //소문자로 시작하는 경우
        if('a' <= s.charAt(0) && s.charAt(0) <= 'z') {
        	strArr[0] = strArr[0].toUpperCase();
        }
        
        //공백으로 시작하면서 문자가 영어인 경우. 소문자
        for(int i=0; i<strArr.length; i++) {
        	while(strArr[i] == " ") {
        		
        	}
        }        
        
        //String 만들기
		StringBuilder sb = new StringBuilder();
		for(String str : strArr) {
			sb.append(str);
		}
        return sb.toString();
    }
}