package programmers_coding_test.unsolved.lv02_jadenCase_���ڿ�_�����;

class Solution {
 public String solution(String s) {
    	String[] strArr = new String[s.length()];
        strArr = s.toLowerCase().split("");
        
        //���� ���� ���� �빮�� ��ȯ
        for(int i=0; i<strArr.length-1; i++) {
        	if(strArr[i].equals(" ")) {
        		strArr[i+1] = strArr[i+1].toUpperCase();
        	}
        }
        
        //�ҹ��ڷ� �����ϴ� ���
        if('a' <= s.charAt(0) && s.charAt(0) <= 'z') {
        	strArr[0] = strArr[0].toUpperCase();
        }
        
        //�������� �����ϸ鼭 ���ڰ� ������ ���. �ҹ���
        for(int i=0; i<strArr.length; i++) {
        	while(strArr[i] == " ") {
        		
        	}
        }        
        
        //String �����
		StringBuilder sb = new StringBuilder();
		for(String str : strArr) {
			sb.append(str);
		}
        return sb.toString();
    }
}