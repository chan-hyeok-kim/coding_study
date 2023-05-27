package chap06.Object.ex01;

class Tv {
	String color;
	boolean power;
	int channel;
	
	void power()              {power =!power;}
	void channelUp()           { ++channel;}
	void channelDown()         { --channel;}    
}
class Ex01{
	public static void main(String[] args) {
		Tv t;
		t = new Tv();
		t.channel = 7;
		t.channelDown();
		System.out.println("현재 채널은 "+ t.channel+ " 입니다");

	}

}
