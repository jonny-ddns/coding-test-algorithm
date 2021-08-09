package unsolved.lv01_체육복;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //잃어버렸는데 체육복을 받은 학생 수 
        int count = 0; 
        
        //반복문 1. 잃어버린 배열
        for(int i=0; i< lost.length; i++) {
        	//잃어버린 항복 가져오기
        	int lost_i = lost[i];
        	
        	if(lost_i < reserve[0]) {
        		
        	}
        	
        	
        	
        }
        
        
        return answer;
    }
}


/*

n	lost	reserve		return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]			4
3	[3]		[1]			2

리턴값은 n보다 클 수 없음
리턴값은 n - lost배열길이 + ...

*/

