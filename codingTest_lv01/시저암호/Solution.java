package level01.������ȣ;
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
			
				//�빮��
				if(64 < b && b < 91) {
					newByte = increaseByte(b, n);
					System.out.println("��ȯ��� : "+ newByte+ " | "+ (char)newByte);
					if(newByte > 90) {
						newByte = decreaseByte(newByte);
					}
				}
				
				//�ҹ���
				if(96 < b && b < 123) {				
					newByte = increaseByte(b, n);
					System.out.println("��ȯ��� : "+ newByte+ " | "+ (char)newByte);
					if(newByte > 122) {
						newByte = decreaseByte(newByte);
					}
				}
				chars[i] = (char) newByte;				
			}
		}
	    return chars;
    } 
    
    //byte �� ������Ű��
    byte increaseByte(byte b, int n) {
    	int temp = (b + n);
    	//����Ʈ �� �ʰ��ϴ� ��� ����
    	if(temp > 127) {
    		temp = temp - 26;
    	}
    	return (byte)temp;
    }   
    
    //byte�� �����ϱ�
    byte decreaseByte(byte b) {
    	byte temp = (byte)(b - 26);
        return temp;        		        	
    }
}