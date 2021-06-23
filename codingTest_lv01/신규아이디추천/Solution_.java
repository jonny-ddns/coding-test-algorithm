package level01.신규아이디추천;
/*
1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.		toLowerCase()
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.		startsWith() / lastIndexOf()
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
*/

import java.util.LinkedList;
import java.util.List;

class Solution_ {
    public String solution(String new_id) {
    	List<Character> list = new LinkedList<>();
        
        //1단계 ; 대문자->소문자 치환
    	new_id = new_id.toLowerCase();
	
    	//2단계 ; 영소문자 / 숫자 / - _ . 외 제외하기 
    	for(int i=0; i<new_id.length(); i++) {
    		if(checkChar(new_id.charAt(i))) {
    			list.add(new_id.charAt(i));
    		}
    	}
    	
    	//3단계 ; 마침표가 여러개 인경우 1개만 작성
    	changeFullstop(list);
    	
    	//4단계 ; 첫글자와 마지막글자가 마침표인 경우 삭제
    	if(list.indexOf('.') == 0){
    		list.remove(0);
    	}
    	
    	deleteFinalFullstop(list);
    	
    	//5단계 ; 빈 문자열에 a 삽입
    	if(list.isEmpty()) {
    		list.add('a');
    	}
    	
    	//6단계 ; 16자 이상시 길이 조정
    	deleteElementOverLength(list);
    	deleteFinalFullstop(list);

    	//7단계 ; 글자개수 2이하일때 문자열 삽입
    	while(list.size() < 3) {
    		list.add(list.get(list.size()-1));
    	}
    	
    	String answer = "";
    	for(char c: list) {
    		answer += c;
    	}
        return answer;
    }
    
    boolean checkChar(char ch){
		if(('a' <= ch && ch <= 'z') || ('0' <= ch && ch < '9') || ch == '-' || ch == '_' || ch == '.') {    	
    		return true;
    	}
    	return false;
    } 
    
    void changeFullstop(List<Character> list) {
    	for(int i=list.size()-1; i>0; i--) {
    		if(list.get(i) == '.' && list.get(i).equals(list.get(i-1))) {
    			list.remove(i);
    		}
    	}
    }
    
    void deleteFinalFullstop(List<Character> list){
    	if((list.lastIndexOf('.') == list.size()-1) && list.size() != 0) {
			list.remove(list.size()-1);
			return;
    	}
    }
    
    void deleteElementOverLength(List<Character> list){
		if(list.size() > 15){
			//리스트 사이즈가 너무 큰 경우 새로 선언하여 필요한 내용만 복사
			if(list.size() > 30) {
				List<Character> listTmp = new LinkedList<>();
				for(int i=0; i<15; i++) {
					listTmp.set(i, list.get(i));
				}
				list.clear();
				list = listTmp;
				listTmp.clear();
			}
			for(int i=list.size()-1; i>14; i--) {
				list.remove(i);
			}
		}
    }
}