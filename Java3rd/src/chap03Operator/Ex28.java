package chap03Operator;

public class Ex28 {

	public static void main(String[] args) {
		   int x = 0xAB, y = 0xF;
		   
		   System.out.printf("x = %#X \t\t%s%n", x, toBinaryString(x));
		   System.out.printf("y = %#X \t\t%s%n", y, toBinaryString(y));
		   System.out.printf("%#X | %#X = %#X \t%s%n", x, y, x|y, toBinaryString(x|y));
		   System.out.printf("%#X & %#X = %#X \t%s%n", x, y, x&y, toBinaryString(x&y));
		   System.out.printf("%#X ^ %#X = %#X \t%s%n", x, y, x^y, toBinaryString(x^y));
		   System.out.printf("%#X ^ %#X ^ %#X = %#X %s%n", x, y, y, x^y^y, toBinaryString(x^y^y));

	}

	private static Object toBinaryString(int x) {
		String zero = "00000000000000000000000000000000";
		String tmp = zero + Integer.toBinaryString(x);
		return tmp.substring(tmp.length()-32);
	}

}
//설명도 없어서 잘 모르겠음 ㅋㅋ
