package unsolved.lv01_문자열내마음대로정렬하기;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
     
        
        List<String> list = new ArrayList<String>();
        for(String str : strings) {
        	list.add(str);	
        }
        //list.sort(null);
        
        System.out.println("정렬결과 확인");
        for(String st: list) {
        	System.out.println(st);
        }
        
        //특정 문자열 기준으로 정렬하기
        for(int i=0; i<list.size()-1; i++){
        	for(int j=i+1; j<list.size(); j++) {
        		char c1 = getChar(list.get(i), n);
        		char c2 = getChar(list.get(j), n);
        		
        		if(c1 > c2) {  
        			String tmp = list.get(i);
        			   
        			list.set(i, list.get(j));
        			list.set(j, tmp);
        		}
        	}        	
        }
        
        //특정 문자열 기준으로 동일한 문자라면 서로 정렬하기
        
      
        
       
        
        
        
        //순서정하기        
        answer = strings;
        return answer;
    }
    
    //1 char 추출하기
    char getChar(String str, int n) {
    	return str.charAt(n);
    }    
}