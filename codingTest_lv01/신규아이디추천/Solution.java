package codingTest_lv01.�űԾ��̵���õ;
//2021.06.18

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

			//������ ���� ���� . ���� Ȯ��
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

		//ù���ڿ� ���������� . Ȯ��
		if(list.get(list.size()-1).equals(".")){
			list.remove(list.size()-1);
		}
		if(!list.isEmpty()){
			if(list.get(0).equals(".")){
				list.remove(0);
			}
		}

		//����Ʈ ���� Ȯ���ϱ�
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
				System.out.println("������ ���ڰ� . ");
				list.remove(list.size()-1);
			}
		}

		//����Ʈ ���̰� 2���϶��
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