package chap06.Object.ex07;

public class Ex07 {

	public static void main(String[] args) {
		firstMethod();
	}
	
	static void firstMethod() {
		secondMethod();

	}
	static void secondMethod() {
		System.out.println("secondMethod()");
	}

}
