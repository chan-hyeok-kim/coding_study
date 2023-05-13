package day02.exam02;

import java.util.*;

public class MySolution {
       public static void main(String[] args) {
    	   
		 Scanner sc = new Scanner(System.in);
		 String a = sc.next();
	     String b = sc.next();
	     
	     if(1<=a.length() && a.length()<=10 && 1<=b.length() && b.length()<=10) {  // 이 줄을 실제 답에서는 안넣었음. 정확히 하려면 넣어주는게 맞는듯?
	     System.out.println(a + b);   

	}            //next는 공백을 포함하지 않는 단어 1개씩만 가져옴
}                //next line은 공백을 포함하는 전체 문장 가져옴
}

/*  두 개의 문자열 str1, str2가 공백으로 구분되어 입력으로 주어집니다.
입출력 예와 같이 str1과 str2을 이어서 출력하는 코드를 작성해 보세요.
 */
