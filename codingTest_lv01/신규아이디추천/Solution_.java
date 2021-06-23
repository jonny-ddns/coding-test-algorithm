package level01.�űԾ��̵���õ;
/*
1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.		toLowerCase()
2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.		startsWith() / lastIndexOf()
5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
     ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
*/

import java.util.LinkedList;
import java.util.List;

class Solution_ {
    public String solution(String new_id) {
    	List<Character> list = new LinkedList<>();
        
        //1�ܰ� ; �빮��->�ҹ��� ġȯ
    	new_id = new_id.toLowerCase();
	
    	//2�ܰ� ; ���ҹ��� / ���� / - _ . �� �����ϱ� 
    	for(int i=0; i<new_id.length(); i++) {
    		if(checkChar(new_id.charAt(i))) {
    			list.add(new_id.charAt(i));
    		}
    	}
    	
    	//3�ܰ� ; ��ħǥ�� ������ �ΰ�� 1���� �ۼ�
    	changeFullstop(list);
    	
    	//4�ܰ� ; ù���ڿ� ���������ڰ� ��ħǥ�� ��� ����
    	if(list.indexOf('.') == 0){
    		list.remove(0);
    	}
    	
    	deleteFinalFullstop(list);
    	
    	//5�ܰ� ; �� ���ڿ��� a ����
    	if(list.isEmpty()) {
    		list.add('a');
    	}
    	
    	//6�ܰ� ; 16�� �̻�� ���� ����
    	deleteElementOverLength(list);
    	deleteFinalFullstop(list);

    	//7�ܰ� ; ���ڰ��� 2�����϶� ���ڿ� ����
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
			//����Ʈ ����� �ʹ� ū ��� ���� �����Ͽ� �ʿ��� ���븸 ����
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