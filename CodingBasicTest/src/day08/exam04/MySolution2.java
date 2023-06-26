package day08.exam04;

public class MySolution2 {
	public static void main(String[] args) {
		String number="123";
	int answer = 0;
    int result = 0;
      
        for(int i=0; i<number.length(); i++){
            result += (int)(number.charAt(i)-'0');
        }     answer = result%9;
     System.out.println(result);
	}
}
