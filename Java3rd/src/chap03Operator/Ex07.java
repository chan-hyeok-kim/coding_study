package chap03Operator;

public class Ex07 {

	public static void main(String[] args) {
		byte a = 10;
		byte b = 30;
		byte c = (byte)(a * b);    //300은 byte의 범위를 넘기 때문에 데이터 손실 발생. 44가 저장
		System.out.println(c);  
		

	}

}
