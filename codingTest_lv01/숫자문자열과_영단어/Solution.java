package codingTest_lv01.���ڹ��ڿ���_���ܾ�;
//2021.07.14

class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = "";

        for(int i=0; i<s.length(); i++){
            //�����Է�
            if(checkIsNumber(s, i)){
                String ab = s.substring(i, i+1);
                str += ab;
            }
            //String �Է�
            else{
                int[] intArr = getNumString(s.substring(i, i+2));
                str += intArr[0];
                i += --intArr[1];
            }
            answer = Integer.parseInt(str);
        }
        return answer;
    }

    //����Ʈ�� �������� Ȯ���ϱ�
    boolean checkIsNumber(String s, int i){
        byte b = s.getBytes()[i];
        boolean isNumber = false;
        if(b>47 && b<58){
            isNumber = true;
        }
        return isNumber;
    }

    //���ڰ� �ƴ϶�� String Ȯ���ϱ�
    int[] getNumString(String s){
        int number = 0;
        int lengthOfStr = 3;
        switch (s){
            case "ze":
                number = 0;
                lengthOfStr = 4;
                break;
            case "on":
                number = 1;
//                lengthOfStr = 3;
                break;
            case "tw":
                number = 2;
//                lengthOfStr = 4;
                break;
            case "th":
                number = 3;
                lengthOfStr = 5;
                break;
            case "fo":
                number = 4;
                lengthOfStr = 4;
                break;
            case "fi":
                number = 5;
                lengthOfStr = 4;
                break;
            case "si":
                number = 6;
//                lengthOfStr = 3;
                break;
            case "se":
                number = 7;
                lengthOfStr = 5;
                break;
            case "ei":
                number = 8;
                lengthOfStr = 5;
                break;
            case "ni":
                number = 9;
                lengthOfStr = 4;
                break;
        }
        int[] intArr = new int[2];
        intArr[0] = number;
        intArr[1] = lengthOfStr;
        return intArr;
    }
}