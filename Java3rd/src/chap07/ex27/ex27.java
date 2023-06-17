package chap07.ex27;

public class A {

	public void methodA(B b) {
		b.methodB();
	}
}

class B {
	public void methodB() {
		System.out.println("methodB()");
	}
}

class ex27 {
	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B());
	}
}
