package programmers_coding_test.unsolved.lv02_���ʰ�;

import java.util.Arrays;

public class Solution3 {
    public int solution(int[] scoville, int K) {
        //�����ϱ�
        Arrays.sort(scoville);
        int count = 0;

        while(scoville[0]<K) {
            scoville = getNewScovillArray(scoville);
            count++;
            if( scoville.length<2 ){
                if( scoville[0]<K ){
                    count = -1;
                }
                break;
            }
        }
        return count;
    }

    //���ο� ���ں� �迭 �����ϱ�
    private int[] getNewScovillArray(int[] scoville){
        int newNumber = getNewNumber(getFirstSecondElement(scoville));
        int[] newScovillArray = getNewArray(scoville, newNumber);
        return newScovillArray;
    }

    //����Ʈ ù��° �׸� �����ϰ� �����ϱ�
    private int[] getFirstSecondElement(int[] scoville){
        int[] intArr = new int[2];
        intArr[0] = scoville[0];
        intArr[1] = scoville[1];
        return intArr;
    }

    //�ΰ� ��� ���ο� ���ں� ���� �����ϱ�
    private int getNewNumber(int[] intArr){
        return intArr[0] + intArr[1]*2;
    }

    //���ο� ���� ����Ʈ�� �ֱ�
    private int[] getNewArray(int[] scoville, int newNumber){

        int arrayLength = scoville.length;
        int[] scoville_new = new int[arrayLength-1];

        //�ݺ� ���鼭 ���ϰ� �� �ֱ�
        //���� 3������ ��ȿ��
        for(int i=2; i<scoville.length; i++){
            scoville_new[i-2] = scoville[i];
        }
        scoville_new[arrayLength-2] = newNumber;
        Arrays.sort(scoville_new);

        return scoville_new;
    }
}
