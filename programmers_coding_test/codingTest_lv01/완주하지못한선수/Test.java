package programmers_coding_test.codingTest_lv01.완주하지못한선수;

public class Test {
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String[] participant = new String[] {"k", "mislav", "stanko", "mislav", "ana", "t"};
		String[] completion = new String[] {"k", "stanko", "ana", "mislav", "t"};

		s.solution(participant, completion);

	}
}
