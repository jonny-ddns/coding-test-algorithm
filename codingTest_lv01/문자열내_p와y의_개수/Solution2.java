package level01.���ڿ���_p��y��_����;

class Solution2 {
    boolean solution(String str){
    	str = str.toLowerCase();
    	byte[] byteArr = str.getBytes();
    	
    	int p = 0;
    	int y = 0;
    	for(int i=0; i<byteArr.length; i++) {
    		if(byteArr[i] == 112) {
    			p++;
    		}
    	}
    	
    	for(int i=0; i<byteArr.length; i++) {
    		if(byteArr[i] == 121) {
    			y++;
    		}
    	}
    	
    	if(p != y) {
			return false;
		}
    	return true;
    }
}