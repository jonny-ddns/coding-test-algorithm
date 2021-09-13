package programmers_coding_test.codingTest_lv01.모의고사;

public class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] intArray = new int[] {4,4,4,1,1};
		int[] answer = null;
		answer = s.solution(intArray);
		for(int i: answer) {
			System.out.println(i);
		}
	}
}
