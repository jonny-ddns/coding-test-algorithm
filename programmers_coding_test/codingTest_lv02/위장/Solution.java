package programmers_coding_test.codingTest_lv02.위장;
//2021.05.28

/*
 * ReadMe
 * 
 * #규칙 
 * 종류 개수를 n
 * 종류별 개수를 각각 x, y, z ... 라고 하면
 * 경우의 수는 (x + y + z) + (xy+ xz + yz) + xyz
 * 좀더 쉽게 계산하면 --> (x+1) * (y+1) * (z+1) -1  이 된다
 * 
 * HashMap(종류 String, 종류별 개수 Integer) 생성하여
 * 반복문 + 조건문으로
 * 같은 종류에 해당하는 의상이라면 개수 1증가시키기
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Set<String> set = getKindSet(clothes);
        Map<String, Integer> map = createClothesMap(set);
       
        for(int i=0; i<clothes.length; i++) {
        	getKindCountMap(map, clothes[i]);
        }
        
        List<Integer> list = getKindList(map);
        answer = chance(list);
        return answer;
    }
    
    //의상 종류로 이루어진 Set 생성
    Set<String> getKindSet(String[][] stringArray) {
    	HashSet<String> hashSetKey = new HashSet<>();
    	for(int i=0; i<stringArray.length;i++) {
    		String s = stringArray[i][1];
    		hashSetKey.add(s);
    	}
    	return hashSetKey;
    }
    
    //Key 값을 매개로 Map 객체 생성. value 값(의상 종류별 개수)은 0으로 할당
    Map<String, Integer> createClothesMap(Set<String> set){
    	Iterator<String> iterator = set.iterator();
    	Map<String, Integer> map = new HashMap<>();
    	
    	while(iterator.hasNext()) {
    		String kind = iterator.next();
    		map.put(kind, 0);
    	}
    	return map;
    }
    
    //Map과 String 배열을 인자값으로 해서 key 값이 일치하는 경우 value 값(의상 종류별 개수)을 1 증가시키기
    void getKindCountMap(Map<String, Integer> map, String[] stringArr){
    	
    	String key = stringArr[1];				//key 값
    	int count = map.get(stringArr[1]);		//증가시킬 값
    	
    	//set에 포함되어있다면
    	if(map.containsKey(stringArr[1])) {
    		map.put(key, count+1);
    	}
    }
    
    //Set의 value(의상 종류별 개수)를 값으로 하는 List 생성
    List<Integer> getKindList(Map<String, Integer> map){
    	List<Integer> list = new ArrayList<>();
    	
    	for(String kind : map.keySet()){
    		list.add(map.get(kind));
    	}
    	return list;
    }
    
    //List를 매개값으로 경우의 수를 계산하기
    int chance(List<Integer> list){
    	int chance = 1;
    	int k = 0;
    	for(int i: list) {
    		//k = i;
    		k = (i+1);
    		chance = chance * k;
    	}
    	return chance-1;
    }
}