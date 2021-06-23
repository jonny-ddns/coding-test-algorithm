package level01.직사각형_별찍기;
//2021.05.29
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<a;i++) {
        	sb.append("*");
        }
        
        for(int i=0;i<b;i++) {
        	System.out.println(sb.toString());
        }
//        for(int i=0;i<b;i++) {
//	        for(int j=0;j<a;j++) {
//	        	System.out.print("*");
//	        }
//	    	System.out.println();
//        }
        sc.close();
    }
}