package codingTest_lv01.핸드폰번호가리기;
//2021.05.10
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int length = phone_number.length();
        
        String first = "";
        String last = phone_number.substring(length-4, length);
       
        for(int i=0; i<length-4; i++) {
        	first = first + "*";
        }       
        answer = first.concat(last);
        return answer;
    }
}