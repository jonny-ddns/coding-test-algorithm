package unsolved.lv01_���￡��_�輭��_ã��;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        String sentence1 = "�輭���� ";
        String sentence2 = "�� �ִ�";

        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                answer = sentence1+ i+ sentence2;
            }
        }
        return answer;
    }
}
