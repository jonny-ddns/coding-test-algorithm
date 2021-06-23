package level01.두개_뽑아서_더하기;
//2021.06.05

import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {    	
    	Set<Integer> set;   
    	Object[] objArr;
    	int[] answer;
    	
    	set = new TreeSet<Integer>();
    	for(int i=0; i<numbers.length; i++) {
    		for(int j=0; j<numbers.length; j++) {
    			if(i != j) {
    				set.add(numbers[i]+numbers[j]);
    			}
    		}
    	}    	
    	
    	objArr = set.toArray();
    	answer = new int[objArr.length];
    	for(int i=0; i<objArr.length; i++) {
    		answer[i] = (Integer) objArr[i];
    	}
    	
        return answer;    
    }    
}