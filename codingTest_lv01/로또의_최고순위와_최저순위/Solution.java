package level01.로또의_최고순위와_최저순위;
//2021.05.27

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

    	int zeroCount = arrayZeroCount(lottos);
    	int same = arrayCompare(arraySort(lottos), arraySort(win_nums));    	
    	int[] answer = new int[] {rankChance(lottoRank(same), zeroCount), lottoRank(same)};
    	        
        return answer;
    }    

    //배열 정렬하기
	int[] arraySort(int[] arrayA){
    	for(int i=0; i<arrayA.length-1; i++) {
        	for(int j=i+1; j<arrayA.length; j++) {
        		if(arrayA[i] >= arrayA[j] ) {
					int temp = arrayA[i];
					arrayA[i] = arrayA[j];
					arrayA[j] = temp;					 
        		}
        	}
        }
    	return arrayA;
    }
	
	//두 배열을 받아 일치하는 개수 세기
	int arrayCompare(int[] arrayA, int[] arrayB) {
		int count = 0;
		int start = 0;
		for(int i=0; i<arrayA.length; i++) {
			for(int j=start; j<arrayB.length; j++) {
				if(arrayA[i] == arrayB[j]) {
					start = j+1;
					count++;
					break;
				}				
			}
		}
		return count;
	}
		
	//배열 element 중 0개수 반환
	int arrayZeroCount(int[] arrayA) {
		int count = 0;
		
		for(int i=0; i<arrayA.length; i++) {
			if(arrayA[i] == 0) {
				count++;
			}
			if(arrayA[i] > 0) {
				return count;
			}
		}		
		return count;
	}
	
	//로또 맞은 개수에서 순위계산하기
	int lottoRank(int count){
		int rank = 0;
		if(count < 2) {
			return 6;
		}
		rank = 7 - count;
		return rank;
	}
	
	//현재 순위와 0개수 인자값. 순위 가능성 반환
	int rankChance(int rank, int zeroCount) {
		int chance = 1;
		chance = rank - zeroCount;
		if(chance < 1){
			return 1;
		};	
		return chance;
	}	
}