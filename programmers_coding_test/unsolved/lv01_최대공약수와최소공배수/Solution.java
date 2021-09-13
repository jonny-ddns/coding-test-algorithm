package programmers_coding_test.unsolved.lv01_최대공약수와최소공배수;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int cf = getCommonFactor(m, n);
        System.out.println("cf : "+ cf);
        
        answer[0] = getCommonFactor(m, n);
        answer[1] = getCommonFactor(m, n);
        return answer;
    }
    int getCommonFactor(int n, int m) {	
    	int number = 0;

    	if(n%m != 0) {
    		getCommonFactor(m, n%m);
    	}
    	if(n%m == 0) {
    		number = m;
    	}    		
    	System.out.println(number);
    	return number;
    }
    
    int getCommonMultiple(int n, int m) {
    	return 0;	
    }
}