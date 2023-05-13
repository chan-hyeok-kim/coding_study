package day02.exam01;

import java.util.*;

public class MySolution {
       public static void main(String[] args) {
    	   
		    Scanner sc = new Scanner(System.in);
	        int a = sc.nextInt();
	        int b = sc.nextInt();
	        
	        if(1<=a && a<=100 && 1<=b && b<=100) {
	        int c = a + b;
            System.out.println(a + " + " + b + " = " + c);
	    }
	}
	}

/* 두 정수 a, b가 주어질 때 다음과 같은 형태의 계산식을 출력하는 코드를 작성해 보세요.
     a + b = c                                                           
     */

