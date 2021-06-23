package level01._3진법뒤집기;
//2021.05.28

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n) {
        double k = toDecimal( toTernary(new ArrayList<Integer>(), n) );
        return (int)k;
    }
    
    //3진법 변환
    List<Integer> toTernary(List<Integer> list, int m){    	
    	while(m/3 > 0) {    		
    		int k = m%3;    		
    		list.add(k);
    		m = m/3;
    	}    	
    	list.add(m%3);
    	return list;
    }
    
    //반전된 값을 계산
    double toDecimal(List<Integer> list){
    	double k = 0;
    	for(int i=0; i<list.size(); i++) {
    		k = k+ list.get(i) * Math.pow(3, list.size() - (i+1));
    	}
    	return k;
    }
}
