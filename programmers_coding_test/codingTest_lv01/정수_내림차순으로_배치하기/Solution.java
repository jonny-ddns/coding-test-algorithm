package programmers_coding_test.codingTest_lv01.정수_내림차순으로_배치하기;
//2021.06.04
import java.util.ArrayList;
import java.util.List;

class Solution {
    public long solution(long n) {
    	String[] strArr = String.valueOf(n).split("");
    	List<String> list = new ArrayList<String>();
    	
    	for(String str : strArr) {
    		list.add(str);
    	}
    	list.sort(null);
    	
    	String answer = "";
    	for(int i=list.size()-1; i>=0; i--) {
    		answer += list.get(i);
    	}
        return Long.parseLong(answer);
    }
}