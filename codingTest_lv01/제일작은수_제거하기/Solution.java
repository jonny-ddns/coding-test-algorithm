package codingTest_lv01.����������_�����ϱ�;
//2021.06.04
//�ý��� �����ε�
class Solution {
    public int[] solution(int[] arr) {
    	
    	if(arr.length == 1) {
    		return new int[] {-1};
    	}    	
    	
        int min = 0;
        //�ּڰ� ���ϱ�
        for(int i=1;i<arr.length;i++) {
        	min = arr[0];
        	if(min > arr[i]) {
        		min = arr[i];
        	}
        }
        
        int[] arrNew = new int[arr.length-1];
        int index = 0;
        for(int i=0; i<arr.length; i++) {        	
        	if(min == arr[i]) {
        		break;
        	}
        	arrNew[i] = arr[i];
        	index++;
        }
        
        for(int i=index+1; i<arr.length; i++) {
        	arrNew[i-1] = arr[i];
        }        
        return arrNew;
    }
}