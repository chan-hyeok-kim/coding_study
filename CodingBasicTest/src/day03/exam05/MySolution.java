package day03.exam05;

public class MySolution {
	public int solution(int a, int b) {
		
		int A1 = Integer.parseInt(String.valueOf(a)+String.valueOf(b));
		int A2 = 2 * a * b;
				 
		return Math.max(A1, A2);
	}   
}
