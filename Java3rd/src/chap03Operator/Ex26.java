package chap03Operator;

public class Ex26 {

	public static void main(String[] args) {
		   int a = 5;
		   int b = 0;
		   
		   System.out.printf("a=%d, b=%d%n", a, b);
		   System.out.printf("a=!0 || ++b!=0 = %b%n", a!=0 || ++b!=0);
		   System.out.printf("a=%d, b=%d%n", a, b);
		   System.out.printf("a==0 && ++b!=0 = %b%n", a==0 && ++b!=0);
		   System.out.printf("a=%d, b=%d%n", a, b);

	}
}
// 좌측에서 거짓이 판명되어 우측 계산을 안한다. 따라서 전부b=0
//좌측이 참으로 판명되면 우측 계산 들어감 
