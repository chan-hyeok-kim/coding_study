package chap07.ex20;

import chap07.ex19.Child;
import chap07.ex19.Parent;

public class ex20 {

	public static void main(String[] args) {
		Parent P = new Child();
		Child c = new Child();
		
		System.out.println("p.x= " + p.x);
		p.method();
		
		System.out.println();
        c.method();
	}
}

class Parent {
	int x = 100;
	
	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 200;
	
	void method() {
		System.out.println("x=" + x);
		System.out.println("super.x=" + super.x);
		System.out.println("this.x=" + this.x);
	}
}
