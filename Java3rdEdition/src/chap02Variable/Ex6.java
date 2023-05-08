package chap02Variable;

import java.util.*;

public class Ex6 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);     // 리소스 리크 경고 왜 뜨는지 모르겠다
		
		System.out.println("두자리 정수를 하나 입력해주세요.>");
		String input = scanner.nextLine();       // Q. 문자를 입력해서 정수로 변환하는 방법은 없을까?
		int num = Integer.parseInt(input);
		
		System.out.println("입력내용 :"+input);
	    System.out.printf("num=%d%n", num);
	}
}
