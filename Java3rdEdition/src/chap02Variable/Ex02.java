package chap02Variable;

public class Ex02 {
	public static void main(String[] args) {
		int x = 10, y = 20;
		int tmp = 0;
		
		System.out.println("x:" + x + " y:" + y);
		tmp = x;
		x = y; 
		y= tmp;
		System.out.println("x:" + x + " y:" + y);
	}
}
