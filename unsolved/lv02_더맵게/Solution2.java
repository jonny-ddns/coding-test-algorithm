package unsolved.lv02_더맵게;

import java.util.Arrays;

class Solution2 {
    public int solution(int[] scoville, int K) {
        //정렬하기
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



    //새로운 스코빌 배열 생성하기
    private int[] getNewScovillArray(int[] scoville){
        System.out.println("getNewScovillArray");

        int newNumber = getNewNumber(getFirstSecondElement(scoville));
        int[] newScovillArray = getNewArray(scoville, newNumber);
        return newScovillArray;
    }

    //리스트 첫번째 항목 리턴하고 삭제하기
    private int[] getFirstSecondElement(int[] scoville){
        System.out.println("getFirstSecondElement");
        int[] intArr = new int[2];
        intArr[0] = scoville[0];
        intArr[1] = scoville[1];
        return intArr;
    }

    //두개 섞어서 새로운 스코빌 지수 생성하기
    private int getNewNumber(int[] intArr){
        System.out.println("getNewNumber");
        return intArr[0] + intArr[1]*2;
    }
    
    //새로운 값을 리스트에 넣기
    private int[] getNewArray(int[] scoville, int newNumber){
        System.out.println("getNewArray");

        int arrayLength = scoville.length;
        int[] scoville_new = new int[arrayLength-1];
        System.out.println("arrayLength : "+ arrayLength);


        //반복 돌면서 비교하고 값 넣기
        //길이 3까지만 유효함
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
        System.out.println("배열 확인");
        for(int i : intArr){
            System.out.print(i+ " ");
        }
        System.out.println("\n 확인 끝");
        sleepForAWhile();
    }

    private void sleepForAWhile(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException ie){

        }
    }
}