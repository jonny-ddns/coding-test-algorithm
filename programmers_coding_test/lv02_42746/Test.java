package programmers_coding_test.lv02_42746;

public class Test {	
	public static void main(String[] args) {
		Solution s = new Solution();		
//		int[] input = new int[]{6, 10, 2};
//		String result = s.solution(input);
//		System.out.println(result);


		//test
		int t;
		t = s.position(2345);
		System.out.println("t = " + t);
		t = s.position(1);
		System.out.println("t = " + t);
		t = s.position(567);
		System.out.println("t = " + t);
		t = s.position(55);
		System.out.println("t = " + t);
	}
}
