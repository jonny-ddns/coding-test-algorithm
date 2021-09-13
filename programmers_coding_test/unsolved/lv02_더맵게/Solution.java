package programmers_coding_test.unsolved.lv02_더맵게;

/*
스코빌 배열을 리스트로 내림차순으로 정렬하기

리스트에 넣기

k 와 비교하기
k 보다 크거나 일치하면 index 리턴하기
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

    //내림차순 리스트에 값 할당하기
    private void changeToList(int[] scoville, List<Integer> scoville_list){
//        System.out.println("changeToList");
        Arrays.sort(scoville);
        for(int i=0; i<scoville.length; i++){
            scoville_list.add(scoville[i]);
        }
    }

    //새로운 스코빌 지수 리스트 생성하기
    private void makeNewScovillList(List<Integer> scoville_list){
//        System.out.println("makeNewScovillList");
        int foodLeast = getAndDeleteFirstElement(scoville_list);
        int foodNext =  getAndDeleteFirstElement(scoville_list);
        int newNumber = getNewNumber(foodLeast, foodNext);
        getNewList(scoville_list, newNumber);
    }

    //리스트 첫번째 항목 리턴하고 삭제하기
    private int getAndDeleteFirstElement(List<Integer> scoville_list){
//        System.out.println("getAndDeleteLastElement");
        int firstElement = scoville_list.get(0);
        scoville_list.remove(0);
        return firstElement;
    }

    //두개 섞어서 새로운 스코빌 지수 생성하기
    private int getNewNumber(int foodFirst, int foodSecond){
//        System.out.println("getNewNumber");
        return foodFirst + foodSecond*2;
    }

    //새로운 값을 리스트에 넣기
    private void getNewList(List<Integer> scoville_list, int newInt){
//        System.out.println("getNewList");
        //반복 돌면서 비교하고 값 넣기
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
        System.out.println("리스트 확인");
        for(int i : list){
            System.out.print(i+ " ");
        }
        System.out.println();
    }
}