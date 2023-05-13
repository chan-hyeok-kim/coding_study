package day01.exam02;

import java.util.*;

public class MySolution {
	 public static void main(String[] args) {
	           
	        Scanner sc = new Scanner(System.in);
	        int a = sc.nextInt();
	        int b = sc.nextInt();
	        boolean val = (-100000 <= a && a <= 100000 && -100000 <= b && b <= 100000);
	        
	        if(val) {
	        System.out.println("a = "+ a);
	        System.out.println("b = "+ b);
            }
	   }
}

//정수 a와 b가 주어집니다. 각 수를 입력받아 입출력 예와 같은 형식으로 출력하는 코드를 작성해 보세요.
