package unsolved.lv01_ü����;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //�Ҿ���ȴµ� ü������ ���� �л� �� 
        int count = 0; 
        
        //�ݺ��� 1. �Ҿ���� �迭
        for(int i=0; i< lost.length; i++) {
        	//�Ҿ���� �׺� ��������
        	int lost_i = lost[i];
        	
        	if(lost_i < reserve[0]) {
        		
        	}
        	
        	
        	
        }
        
        
        return answer;
    }
}


/*

n	lost	reserve		return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]			4
3	[3]		[1]			2

���ϰ��� n���� Ŭ �� ����
���ϰ��� n - lost�迭���� + ...

*/

