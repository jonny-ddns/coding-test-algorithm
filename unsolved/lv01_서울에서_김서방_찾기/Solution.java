package unsolved.lv01_서울에서_김서방_찾기;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        String sentence1 = "김서방은 ";
        String sentence2 = "에 있다";

        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                answer = sentence1+ i+ sentence2;
            }
        }
        return answer;
    }
}
