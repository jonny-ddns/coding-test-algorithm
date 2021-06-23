package level01.시저암호;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String sSmall	= "abcdefghijklmnopqrstuvwxyz";
		String sbig		= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String test		= "ijklmno";
		int n = 20;
		
		String str1 = sol.solution(sSmall, n);
		String str2 = sol.solution(sbig, n);
		String str3 = sol.solution(test, n);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
}
