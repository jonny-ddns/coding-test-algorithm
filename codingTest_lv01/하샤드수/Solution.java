package level01.ÇÏ»þµå¼ö;
//2021.06.04
class Solution {
    public boolean solution(int x) {
        int number = 0;
        for(int i=0; i<String.valueOf(x).split("").length; i++) {
        	number += Integer.parseInt(String.valueOf(x).split("")[i]);
        }
        if(x%number == 0) {
        	return true;
        }
        return false;
    }
}
