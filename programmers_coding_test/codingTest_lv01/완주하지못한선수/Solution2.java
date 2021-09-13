package programmers_coding_test.codingTest_lv01.완주하지못한선수;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution2 {
    public String solution(String[] participant, String[] completion) {    	
    	return compareTwoMap(arrayToMap(participant), arrayToMap(completion));
    }
    
    Map<String, Integer> arrayToMap(String[] strArr){
    	Map<String, Integer> map = new HashMap<>();
    	
    	for(String str : strArr) {
    		if(!map.containsKey(str)) {
    			map.put(str, 1);
    		} if(map.containsKey(str)) {
    			map.replace(str, map.get(str)+1);
    		}
    	}   	
    	return map;
    }
    
    String compareTwoMap(Map<String, Integer> participant, Map<String, Integer> completion) {
    	Set<String> keySet = participant.keySet();
    	String player = ""; 
    	for(String name : keySet) {
    		if(!participant.get(name).equals(completion.get(name))) {
    			player = name;
    			break;
    		}
    	}
		return player;
    }
}