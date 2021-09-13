package programmers_coding_test.unsolved.lv02_jadenCase_문자열_만들기;

public class Test {
	public static void main(String[] args) {
		long l1;
		long l2;
		long l3;
//		String str = "test TEST hi heawioesdjfkasuohjfidsk sdfjasdlfj sdfj sdkjf ;dksljfds sdf llotest TEST hi hellotest TEST hi hellotest TEST hi hellotest TEST hi hellotest TEST hi hellotest TEST hi hellotest TEST hi hellotest TEST hi hellotest TEST hi hellotest TEST hi hellotest TEST hi hello";
//		String str = "1";
		
		String str = " s7Tes t  ";
		
		String answer = "";
		
		l1 = System.nanoTime();
		Solution s = new Solution();
		answer = s.solution(str);
		
		l2 = System.nanoTime();
		l3 = l2 - l1;
		
		System.out.println(answer);
		System.out.println("걸린시간(nano) : "+ l3);
		System.out.println("걸린시간(mili) : "+ l3/1000000);
		System.out.println(str.length());
		System.out.println(answer.length());
		
		
//		String k1 = " ";
//		String k2 = "  ";
//		
//		System.out.println(k1.length());
//		System.out.println(k2.length());

	}
}
