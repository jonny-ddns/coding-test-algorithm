package level01._3����������;
//2021.05.28

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n) {
        double k = toDecimal( toTernary(new ArrayList<Integer>(), n) );
        return (int)k;
    }
    
    //3���� ��ȯ
    List<Integer> toTernary(List<Integer> list, int m){    	
    	while(m/3 > 0) {    		
    		int k = m%3;    		
    		list.add(k);
    		m = m/3;
    	}    	
    	list.add(m%3);
    	return list;
    }
    
    //������ ���� ���
    double toDecimal(List<Integer> list){
    	double k = 0;
    	for(int i=0; i<list.size(); i++) {
    		k = k+ list.get(i) * Math.pow(3, list.size() - (i+1));
    	}
    	return k;
    }
}
