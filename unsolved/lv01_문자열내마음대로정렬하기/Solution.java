package unsolved.lv01_���ڿ���������������ϱ�;

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
        
        System.out.println("���İ�� Ȯ��");
        for(String st: list) {
        	System.out.println(st);
        }
        
        //Ư�� ���ڿ� �������� �����ϱ�
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
        
        //Ư�� ���ڿ� �������� ������ ���ڶ�� ���� �����ϱ�
        
      
        
       
        
        
        
        //�������ϱ�        
        answer = strings;
        return answer;
    }
    
    //1 char �����ϱ�
    char getChar(String str, int n) {
    	return str.charAt(n);
    }    
}