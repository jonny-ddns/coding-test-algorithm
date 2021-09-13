package programmers_coding_test.codingTest_lv01.문자열을_정수로_바꾸기;
//2021.06.04
class Solution {
    public int solution(String s) {
        if(s.charAt(0) == '-') {       	
        	int number = Integer.parseInt(s.substring(1));
            return number-2*number;
        }
        return Integer.parseInt(s);
    }
}