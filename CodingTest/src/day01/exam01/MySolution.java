package day01.exam01;

public class MySolution {
	public static int sum(int num1, int num2) {
	
		int x = num1;
		int y = num2;
		if(x >= -50000 && x <= 50000 && y >= -50000 && y <= 50000) {
		int sum= x + y;
		return sum;
	}else {
		throw new IllegalArgumentException();
	}
	
}
}
