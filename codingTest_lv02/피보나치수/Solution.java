package codingTest_lv02.피보나치수;
//2021.06.08
class Solution {
    public int solution(int n) {
    	return (int) getFibonacci_Remainder(n, 1234567) % 1234567;    	
    }
    
    double getFibonacci_Remainder(double n, double m){
    	double fibon	= 1;
    	double tmp		= 0;
    	double a		= 0;
    	double b		= 1;
    	double b_		= 0;
    	if(n == 0) {
    		return 0;
    	}
    	for(double i=0; i<n-1 ; i++) {
    		b_		= b%m;    		
    		tmp		= a;
    		a		= b_;
    		b		= tmp + b_;
    		fibon	= b;
    	}
    	return fibon;
    }
}