package programmers_coding_test.codingTest_lv02.����;
//2021.05.28

/*
 * ReadMe
 * 
 * #��Ģ 
 * ���� ������ n
 * ������ ������ ���� x, y, z ... ��� �ϸ�
 * ����� ���� (x + y + z) + (xy+ xz + yz) + xyz
 * ���� ���� ����ϸ� --> (x+1) * (y+1) * (z+1) -1  �� �ȴ�
 * 
 * HashMap(���� String, ������ ���� Integer) �����Ͽ�
 * �ݺ��� + ���ǹ�����
 * ���� ������ �ش��ϴ� �ǻ��̶�� ���� 1������Ű��
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
    
    //�ǻ� ������ �̷���� Set ����
    Set<String> getKindSet(String[][] stringArray) {
    	HashSet<String> hashSetKey = new HashSet<>();
    	for(int i=0; i<stringArray.length;i++) {
    		String s = stringArray[i][1];
    		hashSetKey.add(s);
    	}
    	return hashSetKey;
    }
    
    //Key ���� �Ű��� Map ��ü ����. value ��(�ǻ� ������ ����)�� 0���� �Ҵ�
    Map<String, Integer> createClothesMap(Set<String> set){
    	Iterator<String> iterator = set.iterator();
    	Map<String, Integer> map = new HashMap<>();
    	
    	while(iterator.hasNext()) {
    		String kind = iterator.next();
    		map.put(kind, 0);
    	}
    	return map;
    }
    
    //Map�� String �迭�� ���ڰ����� �ؼ� key ���� ��ġ�ϴ� ��� value ��(�ǻ� ������ ����)�� 1 ������Ű��
    void getKindCountMap(Map<String, Integer> map, String[] stringArr){
    	
    	String key = stringArr[1];				//key ��
    	int count = map.get(stringArr[1]);		//������ų ��
    	
    	//set�� ���ԵǾ��ִٸ�
    	if(map.containsKey(stringArr[1])) {
    		map.put(key, count+1);
    	}
    }
    
    //Set�� value(�ǻ� ������ ����)�� ������ �ϴ� List ����
    List<Integer> getKindList(Map<String, Integer> map){
    	List<Integer> list = new ArrayList<>();
    	
    	for(String kind : map.keySet()){
    		list.add(map.get(kind));
    	}
    	return list;
    }
    
    //List�� �Ű������� ����� ���� ����ϱ�
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