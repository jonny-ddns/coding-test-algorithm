package programmers_coding_test.unsolved.lv02_���ʰ�;

/*
���ں� �迭�� ����Ʈ�� ������������ �����ϱ�

����Ʈ�� �ֱ�

k �� ���ϱ�
k ���� ũ�ų� ��ġ�ϸ� index �����ϱ�
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int[] scoville, int K) {
        List<Integer> scoville_list = new LinkedList<>();
        changeToList(scoville, scoville_list);

        int count = 0;
        while(scoville_list.get(0) < K) {
//            System.out.println("while");
            makeNewScovillList(scoville_list);
            count++;
            if(scoville_list.size()<2) {

                if(scoville_list.get(0) < K){
                    count = -1;
                }
                break;
            }
            System.out.println("count : "+ count);
        }
        return count;
    }

    //�������� ����Ʈ�� �� �Ҵ��ϱ�
    private void changeToList(int[] scoville, List<Integer> scoville_list){
//        System.out.println("changeToList");
        Arrays.sort(scoville);
        for(int i=0; i<scoville.length; i++){
            scoville_list.add(scoville[i]);
        }
    }

    //���ο� ���ں� ���� ����Ʈ �����ϱ�
    private void makeNewScovillList(List<Integer> scoville_list){
//        System.out.println("makeNewScovillList");
        int foodLeast = getAndDeleteFirstElement(scoville_list);
        int foodNext =  getAndDeleteFirstElement(scoville_list);
        int newNumber = getNewNumber(foodLeast, foodNext);
        getNewList(scoville_list, newNumber);
    }

    //����Ʈ ù��° �׸� �����ϰ� �����ϱ�
    private int getAndDeleteFirstElement(List<Integer> scoville_list){
//        System.out.println("getAndDeleteLastElement");
        int firstElement = scoville_list.get(0);
        scoville_list.remove(0);
        return firstElement;
    }

    //�ΰ� ��� ���ο� ���ں� ���� �����ϱ�
    private int getNewNumber(int foodFirst, int foodSecond){
//        System.out.println("getNewNumber");
        return foodFirst + foodSecond*2;
    }

    //���ο� ���� ����Ʈ�� �ֱ�
    private void getNewList(List<Integer> scoville_list, int newInt){
//        System.out.println("getNewList");
        //�ݺ� ���鼭 ���ϰ� �� �ֱ�
        int size = scoville_list.size();

        for(int i=0; i<scoville_list.size(); i++){
            if(newInt <= scoville_list.get(i)){
                scoville_list.add(i, newInt);
                break;
            }
        }
        if(size == scoville_list.size()){
            scoville_list.add(scoville_list.size(), newInt);
        }
//        printList(scoville_list);
    }

    private void printList(List<Integer> list){
        System.out.println("����Ʈ Ȯ��");
        for(int i : list){
            System.out.print(i+ " ");
        }
        System.out.println();
    }
}