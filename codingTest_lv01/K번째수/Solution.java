package codingTest_lv01.K��°��;
//2021.05.07
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};                
        answer = new int[commands.length];
        
        int[] intArray = null;
        //arrayTemp = null;
        
        for(int i=0; i<commands.length; i++) {
        	//�迭 ����
        	intArray = commands[i];
        
        	int start	= intArray[0];
            int end 	= intArray[1];
            int count	= intArray[2];
            int num		= end-start+1; 
            
            //���ĵ� ���ڸ� ���� �迭 ����
            int[] arrayNew = new int[num];

            //������ ���ڸ�ŭ ���ο� �迭�� ���
            for(int j=0; j<num ; j++) {
            	arrayNew[j] = array[j+start-1];
            }
            

            int temp;	//�ӽ� ����
            int arrayLength = arrayNew.length;
            
            //������� ���� �����ϱ�
            for(int x=0; x<arrayLength; x++) {
            	for(int y=0; y<arrayLength-x-1; y++) {
            		if(arrayNew[y] > arrayNew[y+1]) {
            			temp = arrayNew[y];
            			arrayNew[y] = arrayNew[y+1];
            			arrayNew[y+1] = temp;
            		}
            	}
            	   
            }
            //answer �迭�� ������ �� ���
            answer[i] = arrayNew[count-1];
        }
        return answer;
    }
}