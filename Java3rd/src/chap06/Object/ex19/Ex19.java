package chap06.Object.ex19;

public class Ex19 {
    long a, b;
	
		long add()  {return a+b;}
		long subtract() {return a-b;}
		long multiply() {return a*b;}
		double divide() {return a/b;}

		static long add(long a, long b)  {return a+b;}
		static long subtract(long a, long b) {return a-b;}
		static long multiply(long a, long b) {return a*b;}
		static double divide(double a, double b) {return a/b;}
}
class MyMathTest2 {
	public static void main(String[] args) {
		System.out.println(Ex19.add(200L, 100L));
		System.out.println(Ex19.subtract(200L, 100L));
		System.out.println(Ex19.multiply(200L, 100L));
		System.out.println(Ex19.divide(200L, 100L));
		
		Ex19 mm = new Ex19();
		mm.a = 200L;
		mm.b = 100L;
		System.out.println(mm.add());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
		
	}

}
