package day01.exam04;
import java.util.Scanner;

public class AnotherSolution {
     public static void main(String args[]) {
    	 
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		
		for(char ch : a.toCharArray()){
			if(Character.isLowerCase(ch)) { // 소문자라면
				ch= Character.toUpperCase(ch);
				System.out.print(ch);
			} else { // 대문자라면
				ch= Character.toLowerCase(ch);
				System.out.print(ch);
			}
			}
		}
}
			

// 확장 for 루프인 for(char ch : a.toCharArray())를 쓰는 버전도 가능하다.
//즉, for(char ch : a.toCharArray())는 문자열(a)을 char 배열로 변환한 후에,
//배열의 각 요소를 하나씩 변수 x에 대입하여 반복하는 것을 의미한다