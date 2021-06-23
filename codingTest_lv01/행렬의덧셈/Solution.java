package level01.Çà·ÄÀÇµ¡¼À;
//2021.06.04
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {    	
    	for(int i=0; i<arr1.length; i++) {    		
    		arr1[i] = addIntArr(getIntArr(arr1, i), getIntArr(arr2, i));
    	}   	
    	return arr1;
    }    
    
    int[] getIntArr(int[][] intArrArr, int i) {
    	return intArrArr[i];
    }
    
    int[] addIntArr(int[] intA, int[] intB) {
    	for(int i=0; i<intA.length; i++) {
    		intA[i] = intA[i] + intB[i];
    	}    	
    	return intA;
    }
}