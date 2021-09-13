package programmers_coding_test.unsolved.lv01_Ű�е崩����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private final List<Integer> list_left = new ArrayList<>(Arrays.asList(1, 4, 7, 10));
    private final List<Integer> list_mid = new ArrayList<>(Arrays.asList(2, 5, 8, 0));
    private final List<Integer> list_right = new ArrayList<>(Arrays.asList(3, 6, 9, 11));

    private int thumb_left = 10;    //�޼� ���� ����
    private int thumb_right = 11;   //������ ���� ����
    private String handMain = "L";  //�ַ� ����ϴ� ��

    public String solution(int[] numbers, String hand) {
        String answer = "";
        String whichThumb = "";

        if (hand == "right") {
            handMain = "R";
        }

        for(int i=0; i<numbers.length; i++){
            int numberToPress = numbers[i];

            //���� ���ڰ� 2 5 8 0 �� �ִٸ�
            if(list_mid.contains(numberToPress)){
                int fromLeft = getDistance(numberToPress, thumb_left);
                int fromRight = getDistance(numberToPress, thumb_right);
                int count = fromLeft - fromRight;

                if(count<0){
                    whichThumb = "L";
                    thumb_left = numberToPress;
                } else if(count>0) {
                    whichThumb = "R";
                    thumb_right = numberToPress;
                } else{
                    whichThumb = handMain;
                   if(whichThumb == "L"){
                       thumb_left = numberToPress;
                   } else{
                       thumb_right = numberToPress;
                   }
                }
            } else if(list_left.contains(numberToPress)){
                whichThumb = "L";
                thumb_left = numberToPress;
            } else if(list_right.contains(numberToPress)){
                whichThumb = "R";
                thumb_right = numberToPress;
            }
            answer += whichThumb;
        }
        return answer;
    }

    //������ȣ(2, 5, 8, 0)�� ����հ����� ��ȣ���� �Ÿ� ����ϱ�
    private int getDistance(int numberToPress, int thumb){
        int caseNum = 0;
        if(list_left.contains(thumb)){
            caseNum = 1;
        } else if(list_right.contains(thumb)){
            caseNum = 2;
        }

        int x = list_mid.indexOf(numberToPress);
        int y = 0;
        int distance = 0;

        switch (Number.values()[caseNum]){
            case middle:
                y = list_mid.indexOf(thumb);
                distance = Math.abs(y-x);
                break;
            case left:
                y = list_left.indexOf(thumb);
                distance = Math.abs(y-x) +1;
                break;
            case right:
                y = list_right.indexOf(thumb);
                distance = Math.abs(y-x) +1;
                break;
        }
        return distance;
    }

    enum Number{
        left, right, middle
    }
}