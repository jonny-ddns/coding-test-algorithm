package programmers_coding_test.codingTest_lv01._2016년;
//2021.06.05
/*
 * 요일 계산하기
 * 일주일은 7일
 * 
 * 월 입력값으로 31, 30, 28 등을 계산하기
 * 일 입력값으로 숫자 더하고 7로 나누기
 * 
 * 
 * [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
 */
public class Solution {
	public String solution(int month, int day) {
		int[] intArr = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int total = 0;
		for(int i=0; i<month-1; i++) {
			total += intArr[i];
		}
		total += day;
		total += 4;		//첫 요일 조정
		
		final String d0 = "SUN";
		final String d1 = "MON";
		final String d2 = "TUE";
		final String d3 = "WED";
		final String d4 = "THU";
		final String d5 = "FRI";
		final String d6 = "SAT";
		String answer = "";
		
		switch (total%7) {
		case 1:
			answer = d1;
			break;
		case 2:
			answer = d2;
			break;
		case 3:
			answer = d3;
			break;
		case 4:
			answer = d4;
			break;
		case 5:
			answer = d5;
			break;
		case 6:
			answer = d6;
			break;
		default:
			answer = d0;
			break;
		}
		return answer;
	}
}
