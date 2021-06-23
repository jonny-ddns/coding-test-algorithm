package level02.뉴스_클러스터링_1차;
//2021.06.16
import java.util.ArrayList;
import java.util.List;

class Exam {
    public int solution(String str1, String str2) {
        int answer = 0;

        //소문자로 비교하기
        List<String> listA = getStringList(str1.toLowerCase());
        List<String> listB =getStringList(str2.toLowerCase());

        //디버깅
        System.out.println("--A");
        for(String st : listA){
            System.out.println(st);
        }

        System.out.println("--B");
        for(String st : listB){
            System.out.println(st);
        }

        //교집합 크기
        double small = compareBothList_small(listA, listB);
        double big = listA.size() + listB.size() - small;

        System.out.println("small: "+ small);
        System.out.println("big : "+ big);
        double tmp = small/big;
        System.out.println("test: "+ tmp* 65536);
        System.out.println("test: "+ Math.floor(tmp* 65536));

        //두 리스트 비교하기 - 교집합 구하기
        return answer;
    }

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
                    System.out.println("일치하네요 "+i+" "+j);
                    count++;
                    index = j+1;
                    break;
                }
            }
            System.out.println("index : "+index+ " "+ "count : "+ count);
        }

        return count;
    }
}