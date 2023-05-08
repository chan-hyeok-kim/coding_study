package chap02Variable;

public class Ex4 {
	public static void main(String[] args) {
		byte b = 1;
		short s = 2;
		char c = 'A';
		
		int finger = 10;
		long big = 100_000_000_000L; 
		long hex = 0xFFFF_FFFF_FFFF_FFFFL;
		
		int octNum = 010; 
		int hexNum = 0x10;
		int binNum = 0b10;
		
		System.out.printf("b=%d%n", b);
		System.out.printf("s=%d%n", s);
		System.out.printf("c=%c, %d %n", c, (int) c);
		System.out.printf("finger=[%5d]%n", finger);
		System.out.printf("finger=[%-5d]%n", finger);
		System.out.printf("finger=[%05d]%n", finger);
		System.out.printf("big=%d%n", big);           //오타로 d대신 b를 넣었더니 true값이 나옴. boolean타입의 b로 인식한 듯
		System.out.printf("hex=%#x%n", hex);      //#은 접두사(16진수 0x, 8진수 0)
		
		System.out.println(octNum);
		System.out.println(hexNum);
		System.out.println(binNum);     //헷갈려서 추가 출력
		
		System.out.printf("octNum=%o, %d%n", octNum, octNum);
		System.out.printf("hexNum=%x, %d%n", hexNum, hexNum);
		System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum), binNum);   //10진수를 2진수로 출력해주는 지시자는 없어서 정수를 2진 문자열로 변환해주는 Integer.toBinaryString(int i)를 사용함
	}

}
