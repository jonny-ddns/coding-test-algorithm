package codingTest_lv01.콜라츠추측;

class Solution {
    public int solution(int num) {
        int answer = 0;
        
        if(num == 1) {
        	return 0;
        }
       
        while(answer < 500) {
        	answer++;
            if(num%2 != 1) {
            	num = num/2;
            } else {
            	num = num * 3 +1;
            }
          
            
            if(num == 1) {
            	break;
            }
        }
        
        if(answer == 500) {
        	answer = -1;
        }
        return answer;
    }
}