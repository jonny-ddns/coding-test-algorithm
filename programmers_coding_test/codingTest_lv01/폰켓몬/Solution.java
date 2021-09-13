package programmers_coding_test.codingTest_lv01.ÆùÄÏ¸ó;
//2021.06.02
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {    	
    	if(getSizeOfSet(nums) < nums.length/2) {
    		return getSizeOfSet(nums);
    	}
    	return nums.length/2;
    }
   
    Integer getSizeOfSet(int[] nums){
    	Set<Integer> set = new HashSet<>();
    	for(int i: nums) {
    		set.add(i);
    	}
    	return set.size();
    }
}