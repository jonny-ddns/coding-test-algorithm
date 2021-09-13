package programmers_coding_test.codingTest_lv01.예산;
//2021.05.29
class Solution {
	public int solution(int[] d, int budget) {
		d = sortArray(d);
		int count = 0;
		int sum = 0;
		for(int i=0; i<d.length; i++) {		
			sum += d[i];			
			if(sum > budget) {
				break;
			}
			count++;
		}
		return count;
	}
	
	//정렬하기
	int[] sortArray(int[] intArr) {
		for(int i=0; i<intArr.length-1; i++) {
			for(int j=i+1; j<intArr.length; j++) {
				if(intArr[i] > intArr[j]) {
					int temp = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = temp;
				}
			}
		}
		return intArr;
	}	
}