package chap07.ex01;

class Tv{
	boolean power;
	int channel;
	
	void power()   { power = !power;}
	void channelup()   {++channel;}
	void channeldown() {--channel;}
}

class CaptionTv extends Tv{
	boolean caption;
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
}
public class ex01 {
	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;
		ctv.channelup();
		System.out.println(ctv.channel);
		ctv.displayCaption("Hello World");
		ctv.caption =true;
		ctv.displayCaption("Hello World");

	}

}
