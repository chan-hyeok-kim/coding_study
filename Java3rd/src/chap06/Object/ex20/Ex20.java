package chap06.Object.ex20;

public class Ex20 {

	public static void main(String[] args) {
		int iv = 10;
		static int cv=20;
		
		int iv2 =cv;
		static int cv2 = iv;
		static int cv2 = new MemberCall().iv;
		
		static void staticMethod1() {
			System.out.println(cv);
			System.out.println(iv);
			MemberCall c =new Membercall();
			System.out.println(c.iv);
}
  void instanceMethod() {
	  System.out.println(cv);
	  System.out.println(iv);
  }
  
  static void staticMethod2() {
	  staticMethod1();
	  instanceMethod1();
	  MemberCall c = new MemberCall();
	  c.instanceMethod1();
  }
  
  void instanceMethod2() {
	  staticMethod1();
	  instanceMethod1();
  }
}

}
