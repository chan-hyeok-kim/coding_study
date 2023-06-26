package chap07.ex36;

public class ex36 {
    Object iv = new Object() {void method() {} };
    static Object cv = new Object() {void method() {} };
	
    void myMethod() {
    	Object lv = new Object() { void method() {} };
	}
}
