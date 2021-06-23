package level01.문자열내_p와y의_개수;

public class Test {
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String str = "pPyY";
		
		
		boolean b = s.solution(str);
		System.out.println(b);
		
		Solution2 s2 = new Solution2();
		s2.solution("pYpY");
	}

	
}
