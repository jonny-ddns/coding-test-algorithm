package level01.���ڿ���_p��y��_����;

class Solution1 {
    boolean solution(String str){
    	str = str.toLowerCase();
    	boolean isSame = true;
    	int p = 0;
    	int y = 0;
    	
    	for(int i=0; i<str.length(); i++) {
    		if(str.charAt(i) == 'p') {
    			p++;
    		}
    		if(str.charAt(i) == 'y') {
    			y++;
    		}   			
    	}
    	if(p != y) {
			return !isSame;
		}
    	return isSame;
    }
}