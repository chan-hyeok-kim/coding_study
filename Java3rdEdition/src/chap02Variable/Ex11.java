package chap02Variable;

public class Ex11 {

	public static void main(String[] args) {
		float f = 9.1234567f;
		int i = Float.floatToIntBits(f);
		
		System.out.printf("%f%n", f);
		System.out.printf("%X%n", i);  // 2진수로 보면 1101 4111F9AD가 저장된 것이나, 2진수에서 1은 절반.
		                               // 1의 값을 반올림하기 때문에 4111F9AE가 실행결과로 나온다. 
	}

}
