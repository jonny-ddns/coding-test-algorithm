package codingTest_lv01.�ڿ���_������_�迭��_�����;
//2021.06.04
class Solution {
    public int[] solution(long n) {
        String[] strArr_orig = Long.toString(n).split("");
        int[] strArr_copy = new int[strArr_orig.length];
        for(int i=0; i<strArr_orig.length; i++) {
        	strArr_copy[strArr_orig.length-i-1] = Integer.parseInt(strArr_orig[i]);
    	}        
        return strArr_copy;
    }
}