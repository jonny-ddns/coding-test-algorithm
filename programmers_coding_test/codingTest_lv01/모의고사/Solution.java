package programmers_coding_test.codingTest_lv01.모의고사;
/*
 * 수포자가 찍는 방식 패턴화
 * 정답과 찍은문제 비교해서 일치하면 count++
 * 한 사람당 맞춘 개수 세기
 * 1, 2, 3번의 개수 오름차순 정렬
 */

//2021.05.28
import java.util.ArrayList;
import java.util.List;

class Solution {	
	
    public int[] solution(int[] answers) {
        int[] answer = {};
        //문제 개수
        int number = answers.length;
   
        //학생별 배열생성
        int[] studentA = studentA(number);
        int[] studentB = studentB(number);
        int[] studentC = studentC(number);

        //정답개수 가져오기
        int answerCountA = compareAnswer(studentA, answers);
        int answerCountB = compareAnswer(studentB, answers);
        int answerCountC = compareAnswer(studentC, answers);
        
        //정답최대개수
        int max = maxCount(answerCountA, answerCountB, answerCountC);
        //정답개수로 학생 가려내기
        List<Integer> list = sortingArray(answerCountA, answerCountB, answerCountC, max);
        
        answer = listToArray(list);
        return answer;
    }
    
    //학생1
    int[] studentA(int number) {
    	int[] studentA = new int[number];
    	for(int i=0; i<number; i++) {
        	switch ((i+1)%5) {
			case 1:
				studentA[i] = 1;
				break;
			case 2:
				studentA[i] = 2;
				break;
			case 3:
				studentA[i] = 3;
				break;
			case 4:
				studentA[i] = 4;
				break;
			case 0:
				studentA[i] = 5;
				break;
			}
        }
    	return studentA;
    }
    
    //학생2
    int[] studentB(int number) {
    	int[] studentB = new int[number];
    	  for(int i=0; i<number; i++) {
          	if((i+1)%2 == 1) {
          		studentB[i] = 2;
          	}
          	if((i+1)%2 == 0) {    		   
          		switch ((i+1)%8) {
          		case 2:
  					studentB[i] = 1;
  					break;
          		case 4:
  					studentB[i] = 3;
  					break;
          		case 6:
  					studentB[i] = 4;
  					break;					
          		case 0:
  					studentB[i] = 5;
  					break;					
          		}
          	}
          }
    	return studentB;
    }
    
    //학생3
    int[] studentC(int number) {
    	int[] studentC = new int[number];
    	  for(int i=0; i<number; i++) {
  			switch ((i+1)%10) {
      		case 1:
      			studentC[i] = 3;
      			break;
      		case 2:
      			studentC[i] = 3;
      			break;
      		case 3:
      			studentC[i] = 1;
      			break;
      		case 4:
      			studentC[i] = 1;
      			break;
      		case 5:
      			studentC[i] = 2;
      			break;
      		case 6:
      			studentC[i] = 2;
      			break;
      		case 7:
      			studentC[i] = 4;
      			break;
      		case 8:
      			studentC[i] = 4;
      			break;
      		case 9:
      			studentC[i] = 5;
      			break;
      		case 0:
      			studentC[i] = 5;
      			break;
          	}
  	    }          
    	return studentC;
    }
    
    //채점해서 맞은 개수 반환
    int compareAnswer(int[] studentArray, int[] answerArray){
    	int count = 0;     	
    	for(int i=0; i<answerArray.length ; i++) {
    		if(studentArray[i] == answerArray[i]) {
    			count++;
    		}
    	}  	
    	return count;
    }
    
    //가장 많이 맞힌 개수 확인하기
    int maxCount(int a, int b, int c) { 	
    	int max = a;
    	
    	if(max < b) {
    		max = b;
    	}
    	if(max < c) {
    		max = c;
    	}
    	return max;
    }
    
    //일치여부 확인해서 List 리턴
    List<Integer> sortingArray(int a, int b, int c, int max) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(max == a) {
    		list.add(1);
    	}
    	if(max == b) {
    		list.add(2);
    	}
    	if(max == c) {
    		list.add(3);    	
    	}
    	return list;
    } 
    
    //List -> array 변환
    int[] listToArray(List<Integer> list){
    	int[] array = new int[list.size()];
   	    int size=0;

   	    for(int temp : list){
    	      array[size++] = temp;
   	    }
   	    return array;
    }
}