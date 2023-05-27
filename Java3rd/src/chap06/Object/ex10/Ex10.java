package chap06.Object.ex10;

class Data { int x; }

public class Ex10 {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() :x = " + d.x);

		change(d);
		System.out.println("After change(d)");
		System.out.println("main() :x = " + d.x);
	}
	
	static void change(Data d) {
		d.x = 1000;
		System.out.println("change() : x = " + d.x);
	}

}
