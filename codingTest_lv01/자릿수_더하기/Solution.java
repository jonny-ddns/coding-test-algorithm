package level01.�ڸ���_���ϱ�;
//2021.06.04
public class Solution {
    public int solution(int n) {
        String[] strArr = String.valueOf(n).split("");
        int answer = 0;
        for(String st : strArr) {
        	answer += Integer.parseInt(st);
        }
        return answer;
    }
}