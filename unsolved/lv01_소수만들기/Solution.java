package unsolved.lv01_소수만들기;

/*
 * 배열에서 가능한 숫자 구성 가져오기
 * --> 서로 다른 3개의 수를 더하기
 * 
 *  
 *  n중에서 3개를 선택하는 경우의 수
 *  : n!/3!
 *  3 -> 1
 *  4 -> 4
 *  5 -> 10
 *  6 -> 20  
 *  
 *  3 숫자를 더할 건데
 *  짝수+ 짝수+ 짝수= 필요없음
 *  홀수+ 홀수+ 짝수= 필요없음
 *  홀수+ 홀수+ 홀수= 필요 
 *  홀수+ 짝수+ 짝수= 필요
 *  
 *  앞선 2가지 경우만 더해서 소수를 판별할 배열로 생성
 *   
 * 소수 판별하기. 판별되면 개수 증가시키기
 */

/*
 * 5인경우 
 *  1 2 3 4 5
 *  o o o x x
 *  o o x o x
 *  o o x x o
 *  
 *  o x o o x
 *  o x o x o
 *  o x x o o
 *  
 *  x o o o x
 *  x o o x o
 *  x o x o o
 *  
 *  x x o o o
 *  
 *  반복문?
 *  만약 앞에서 선택했다면. 3개에서 2개만 선택할 수 있음
 *  
 *  
 */

class Solution {
    public int solution(int[] nums) {
        int answer = -1;

        return answer;
    }
    
    
    int[] numberAvailable(int[] nums) {
    	/*
    	 * 숫자 3개를 더하는 방법이 좋다
    	 * how
    	 * 
    	 * 
    	 */
 	
    	
    	return null;
    }
}