package programmers_coding_test.codingTest_lv02.������_�簢��;
//2021.06.12
/*
���� 20, ���� 2���
���δ� 20ĭ�̴ϱ� 20�� �����ؾ���
�׷��� ���δ� 2/20��ŭ ��ü ���α��̿��� ���Ҹ� �ϰ� �ȴ�
���� ��ü ���̿��� ������ ���̸� �����ϰ� 
*/

class Solution {
    public long solution(int w, int h) {
        long sum = 0;
        double width = w;
        double height = h;        
        double length_nature = 0;
        for(int i=1; i<=w; i++) {        	
        	length_nature = Math.floor(height - height/width*i);
        	sum += length_nature;
        }        
        return sum*2;
    }
}