package unsolved.lv01_같은_숫자는_싫어;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(int[] arr) {
    	Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int i : arr) {
        	if(!map.containsKey(index)) {
        		System.out.println("if-not");
        		map.put(index, i);
        	} else {
        		System.out.println("if-ok");
        		index++;
        	}
        }        
        int[] answer = new int[map.size()];
        for(int i=0; i<map.size(); i++) {
        	answer[i] = map.get(i);
        }       
        return answer;
    }
}