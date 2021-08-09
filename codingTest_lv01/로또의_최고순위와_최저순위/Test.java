package codingTest_lv01.로또의_최고순위와_최저순위;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] lottos = new int[] {0, 0, 0, 0, 0, 0};
		int[] win_nums = new int[] {38, 19, 20, 40, 15, 25};
	
		System.out.println(Arrays.toString(s.solution(lottos, win_nums)));
	}
}
