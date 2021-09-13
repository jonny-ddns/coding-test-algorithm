package programmers_coding_test.codingTest_lv01.완주하지못한선수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution1 {
    public String solution(String[] participant, String[] completion) {
 
        List<String> listParticipant	= changeToList(participant);
        List<String> listCompletion		= changeToList(completion);    
        
        int pSize = listParticipant.size();
        
        for(int i=0; i<pSize-1; i++) {        	
        	if(!listParticipant.get(i).equals(listCompletion.get(i))) {
        		return listParticipant.get(i);
        	}
        }
        return listParticipant.get(pSize-1);
    }
    
    List<String> changeToList(String[] strArr) {
    	List<String> list = new ArrayList<>();
    	list = Arrays.asList(strArr);
    	list.sort(null);
    	return list;
    }
}