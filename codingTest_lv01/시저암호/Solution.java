package level01.시저암호;
//2021.05.27
class Solution {
    public String solution(String s, int n) {
    	char[] charS = s.toCharArray();
    	charS = changeChar(charS, n);
    	return String.valueOf(charS);        
    }
    
    char[] changeChar(char[] chars ,int n) {
	    for(int i=0; i<chars.length; i++) {
			if(chars[i] != ' ') {
				byte newByte = 0;				
				byte b = (byte) chars[i];			
			
				//대문자
				if(64 < b && b < 91) {
					newByte = increaseByte(b, n);
					System.out.println("변환결과 : "+ newByte+ " | "+ (char)newByte);
					if(newByte > 90) {
						newByte = decreaseByte(newByte);
					}
				}
				
				//소문자
				if(96 < b && b < 123) {				
					newByte = increaseByte(b, n);
					System.out.println("변환결과 : "+ newByte+ " | "+ (char)newByte);
					if(newByte > 122) {
						newByte = decreaseByte(newByte);
					}
				}
				chars[i] = (char) newByte;				
			}
		}
	    return chars;
    } 
    
    //byte 값 증가시키기
    byte increaseByte(byte b, int n) {
    	int temp = (b + n);
    	//바이트 값 초과하는 경우 조정
    	if(temp > 127) {
    		temp = temp - 26;
    	}
    	return (byte)temp;
    }   
    
    //byte값 조정하기
    byte decreaseByte(byte b) {
    	byte temp = (byte)(b - 26);
        return temp;        		        	
    }
}