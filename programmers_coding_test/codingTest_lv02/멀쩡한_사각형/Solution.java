package programmers_coding_test.codingTest_lv02.멀쩡한_사각형;
//2021.06.12
/*
가로 20, 세로 2라면
가로는 20칸이니까 20번 증가해야함
그러면 세로는 2/20만큼 전체 세로길이에서 감소를 하게 된다
세로 전체 길이에서 감소한 길이를 제외하고 
*/

class Solution {
    public long solution(int w, int h) {
        long sum = 0;
        double width = w;
        double height = h;        
        double length_nature = 0;
        for(int i=1; i<=w; i++) {        	
        	length_nature = Math.floor(height - height/width*i);
        	sum += length_nature;
        }        
        return sum*2;
    }
}