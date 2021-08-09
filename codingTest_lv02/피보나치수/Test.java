package codingTest_lv02.피보나치수;

//0 1 1 2 3 5 8 13 21 34 55 89
public class Test {
	public static void main(String[] args) {    	
		Solution s = new Solution();

		long n1;
		long n2;
		long n3;
		double k;
		int n = 100000000;
		int m = 122;
		
		n1	= System.nanoTime();
		k	= s.getFibonacci_Remainder(n, m);
		n2	= System.nanoTime();
		n3	= n2 - n1;
						
		System.out.println("nonoTime : "+ n3);
		System.out.println("MiliTime : "+ n3/1000000);
		System.out.println("second : "+ n3/1000000000);		
		System.out.println("answer : "+ k);
	}
}
