package level02.뉴스_클러스터링_1차;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        //소문자로 변환 후 문자열 리스트 리턴
        List<String> listA = getStringList(str1.toLowerCase());
        List<String> listB =getStringList(str2.toLowerCase());

        //집합 크기 비교하기
        double small = compareBothList_small(listA, listB);
        double big = listA.size() + listB.size() - small;
        if(big == 0){
            return 65536;
        }
        double tmp = Math.floor(small/big* 65536);
        return (int) tmp;

    }

    //영어로 된 문자열만 리스트에 추가하기
    List<String> getStringList(String str){
        List<String> list = new ArrayList<>();
        for(int i=0; i<str.length()-1; i++){
            String t = str.substring(i, i+2);
            if('a' <= t.charAt(0) && t.charAt(0) <= 'z' &&'a' <= t.charAt(1) && t.charAt(1) <= 'z' ){
                list.add(t);
            }
        }
        list.sort(null);
        return list;
    }

    //교집합의 크기 구하기
    int compareBothList_small(List listA, List listB){
        int index = 0;
        int count = 0;
        for(int i=0; i<listA.size(); i++){
            for(int j=index; j<listB.size(); j++){
                if( listA.get(i).equals(listB.get(j)) ){
                    count++;
                    index = j+1;
                    break;
                }
            }
        }
        return count;
    }
}