package level01.음양더하기;
//2021.06.18
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int index = absolutes.length;
        int sum = 0;
        for(int i=0; i<index; i++){
            if(signs[i]){
                sum += absolutes[i];
            } else if(!signs[i]){
                sum -= absolutes[i];
            };
        }
        return sum;
    }
}