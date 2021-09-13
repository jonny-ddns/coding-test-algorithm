package programmers_coding_test.codingTest_lv01.같은_숫자는_싫어;

public class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] intArr = new int[] {4,4,4,4,4,3,3};
		int[] answer = s.solution(intArr);
		for(int a : answer) {
			System.out.print(a+ " ");
		}
	}
}
