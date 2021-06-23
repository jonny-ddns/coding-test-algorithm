package level02.����_Ŭ�����͸�_1��;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        //�ҹ��ڷ� ��ȯ �� ���ڿ� ����Ʈ ����
        List<String> listA = getStringList(str1.toLowerCase());
        List<String> listB =getStringList(str2.toLowerCase());

        //���� ũ�� ���ϱ�
        double small = compareBothList_small(listA, listB);
        double big = listA.size() + listB.size() - small;
        if(big == 0){
            return 65536;
        }
        double tmp = Math.floor(small/big* 65536);
        return (int) tmp;

    }

    //����� �� ���ڿ��� ����Ʈ�� �߰��ϱ�
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

    //�������� ũ�� ���ϱ�
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