package day01.exam04;

import java.util.*;

public class MySolution {
       public static void main(String[] args) {
    	   
	        Scanner sc = new Scanner(System.in);
	        String a = sc.next();
	        char[] ch= a.toCharArray();
	       
            if(1<=a.length() && a.length()<=20) {
            	for (int i = 0; i < ch.length; i++) {
            	if(Character.isLowerCase(ch[i])) { 
            		ch[i] = Character.toUpperCase(ch[i]);
            		System.out.print(ch[i]);
            	} else if(Character.isUpperCase(ch[i])){
            		ch[i] = Character.toLowerCase(ch[i]);
	        	    System.out.print(ch[i]);   	
	       }  
	     }
	   }
    }
}
	
/*영어 알파벳으로 이루어진 문자열 str이 주어집니다. 
각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성해 보세요.*/
