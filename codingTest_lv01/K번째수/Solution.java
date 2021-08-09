package codingTest_lv01.K번째수;
//2021.05.07
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};                
        answer = new int[commands.length];
        
        int[] intArray = null;
        //arrayTemp = null;
        
        for(int i=0; i<commands.length; i++) {
        	//배열 추출
        	intArray = commands[i];
        
        	int start	= intArray[0];
            int end 	= intArray[1];
            int count	= intArray[2];
            int num		= end-start+1; 
            
            //정렬된 숫자를 담을 배열 생성
            int[] arrayNew = new int[num];

            //지정된 숫자만큼 새로운 배열에 담기
            for(int j=0; j<num ; j++) {
            	arrayNew[j] = array[j+start-1];
            }
            

            int temp;	//임시 변수
            int arrayLength = arrayNew.length;
            
            //순서대로 숫자 정렬하기
            for(int x=0; x<arrayLength; x++) {
            	for(int y=0; y<arrayLength-x-1; y++) {
            		if(arrayNew[y] > arrayNew[y+1]) {
            			temp = arrayNew[y];
            			arrayNew[y] = arrayNew[y+1];
            			arrayNew[y+1] = temp;
            		}
            	}
            	   
            }
            //answer 배열에 추출한 값 담기
            answer[i] = arrayNew[count-1];
        }
        return answer;
    }
}