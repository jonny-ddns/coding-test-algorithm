package codingTest_lv01.약수의개수와덧셈;

/*
 * 약수의 개수 구하기 
 * 개수의 홀짝 구분
 * 홀짝에 따른 계산하기
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
    
    //약수 개수 구하기
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
    
    //짝수인가 판단하기
    boolean isEven(int x) {
    	if(x%2 == 0) {
    		return true;
    	}
    	return false;
    }
    
    //계산식
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