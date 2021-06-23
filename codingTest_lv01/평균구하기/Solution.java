package level01.Æò±Õ±¸ÇÏ±â;
//2021.06.04
class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        int length = arr.length;
        for(int i : arr) {
        	sum += i;
        }
        return (double)sum/length;
    }
}