package codingTest_lv01.����ǰ����͵���;

/*
 * ����� ���� ���ϱ� 
 * ������ Ȧ¦ ����
 * Ȧ¦�� ���� ����ϱ�
 */

//2021.05.28
class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i=left; i<right+1; i++) {
        	answer = sum(answer, i, isEven(countMeasure(i)));
        }           
        return answer;
    }    
    
    //��� ���� ���ϱ�
    int countMeasure(int n) {
    	if(n == 1) {
    		return 1;
    	}        
    	int count = 2;
    	
        for(int i=1; i<n/2; i++) {
        	if(n%(i+1) == 0) {
        		count++;
          	}
        }
        return count;
    }
    
    //¦���ΰ� �Ǵ��ϱ�
    boolean isEven(int x) {
    	if(x%2 == 0) {
    		return true;
    	}
    	return false;
    }
    
    //����
    int sum(int sum, int number, boolean isEven){
    	if(isEven) {
    		sum = sum + number;
    	}
    	if(!isEven) {
    		sum = sum - number;
    	}
    	return sum;
    }
}