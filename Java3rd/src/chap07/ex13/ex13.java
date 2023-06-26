package chap07.ex13;

public class ex13 {

	public static void main(String[] args) {
		Time t = new Time(12, 35, 30);
		System.out.println(t);
//		t.hour = 13;
        t.setHour(t.getHour()+1);
        System.out.println(t);
	}
}

class Time {
	private int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	
	public int getHour() {       return hour;  }
	public void setHour(int hour) {
		if(hour < 0 || hour > 23) return;
		this.hour = hour;
	}
	
	public int getMinute() {       return minute; }
		public void setMinute(int minute) {
			if(minute < 0 || minute > 23) return;
			this.minute = minute;
	}
	
	public int getSecond() {       return second; }
	public void setSecond(int second) {
			if(second < 0 || second > 23) return;
			this.second = second;		
	}
	public String toString() {
	     return hour + ":" + minute + ":" + second;			 
	}
}
