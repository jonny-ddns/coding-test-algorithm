package unsolved.lv02_���ʰ�;

import java.util.Arrays;

class Solution2 {
    public int solution(int[] scoville, int K) {
        //�����ϱ�
        Arrays.sort(scoville);

        int count = 0;
        while(scoville[0]<K) {
            System.out.println("--------------");
            System.out.println("while");
            scoville = getNewScovillArray(scoville);
            count++;
            if( scoville.length<2 ){
                if( scoville[0]<K ){
                    count = -1;
                }
                break;
            }
            System.out.println("count : "+ count);
        }
        return count;
    }



    //���ο� ���ں� �迭 �����ϱ�
    private int[] getNewScovillArray(int[] scoville){
        System.out.println("getNewScovillArray");

        int newNumber = getNewNumber(getFirstSecondElement(scoville));
        int[] newScovillArray = getNewArray(scoville, newNumber);
        return newScovillArray;
    }

    //����Ʈ ù��° �׸� �����ϰ� �����ϱ�
    private int[] getFirstSecondElement(int[] scoville){
        System.out.println("getFirstSecondElement");
        int[] intArr = new int[2];
        intArr[0] = scoville[0];
        intArr[1] = scoville[1];
        return intArr;
    }

    //�ΰ� ��� ���ο� ���ں� ���� �����ϱ�
    private int getNewNumber(int[] intArr){
        System.out.println("getNewNumber");
        return intArr[0] + intArr[1]*2;
    }
    
    //���ο� ���� ����Ʈ�� �ֱ�
    private int[] getNewArray(int[] scoville, int newNumber){
        System.out.println("getNewArray");

        int arrayLength = scoville.length;
        int[] scoville_new = new int[arrayLength-1];
        System.out.println("arrayLength : "+ arrayLength);


        //�ݺ� ���鼭 ���ϰ� �� �ֱ�
        //���� 3������ ��ȿ��
        for(int i=2; i<scoville.length; i++){
            scoville_new[i-2] = scoville[i];
        }
        printArray(scoville_new);



        scoville_new[arrayLength-2] = newNumber;
        Arrays.sort(scoville_new);

        printArray(scoville_new);
        return scoville_new;
    }

    private void printArray(int[] intArr){
        System.out.println("�迭 Ȯ��");
        for(int i : intArr){
            System.out.print(i+ " ");
        }
        System.out.println("\n Ȯ�� ��");
        sleepForAWhile();
    }

    private void sleepForAWhile(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException ie){

        }
    }
}