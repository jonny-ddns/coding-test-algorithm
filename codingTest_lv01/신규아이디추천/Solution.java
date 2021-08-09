package codingTest_lv01.신규아이디추천;
//2021.06.18

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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
	public String solution(String new_id) {
		List<String> list = new LinkedList<>();
		List<String> stringList  = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "_", ".");

		boolean wasFullstop = false;
		for (int i=0; i<new_id.length(); i++) {
			String characterToAdd = new_id.substring(i, i+1).toLowerCase();

			//직전에 들어온 값이 . 인지 확인
			if(stringList.contains(characterToAdd)){
				if(characterToAdd.equals(".")){
					if(wasFullstop){
						continue;
					}
					wasFullstop = true;
				} else {
					wasFullstop = false;
				}

				list.add(characterToAdd);
			}
		}

		//첫글자와 마지막글자 . 확인
		if(list.get(list.size()-1).equals(".")){
			list.remove(list.size()-1);
		}
		if(!list.isEmpty()){
			if(list.get(0).equals(".")){
				list.remove(0);
			}
		}

		//리스트 길이 확인하기
		if(list.size() == 0){
			list.add("a");
		} else if(list.size() > 15){
			List<String> listTmp = new LinkedList<>();
			for(int i=0; i<15; i++){
				listTmp.add(list.get(i));
			}
			list.clear();
			list = listTmp;

			while(list.get(list.size()-1).equals(".")){
				System.out.println("마지막 글자가 . ");
				list.remove(list.size()-1);
			}
		}

		//리스트 길이가 2이하라면
		while(list.size() < 3){
			list.add(list.get(list.size() -1));
		}

		String answer = "";
		while(!list.isEmpty()){
			answer += list.remove(0);
		}
		return answer;
	}
}