package codingTest_lv01.문자열내_p와y의_개수;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
	boolean solution(String str){
		List<Character> list = new ArrayList<>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == 'p' || str.charAt(i) == 'P'
				|| str.charAt(i) == 'y' || str.charAt(i) == 'Y')
			{
				list.add(str.charAt(i));				
			}
		}
		if(list.size() == 0) {
			return true;
		}
		if(list.size() %2 != 0) {
			return false;
		}
		
		int m = 0;
		
		for(char c: list) {
			if(c == 'p' || c == 'P') {
				m++;
			}
		}
		if(m == list.size()/2) {
			return true;	
		}
		return false;	  
	}
}
