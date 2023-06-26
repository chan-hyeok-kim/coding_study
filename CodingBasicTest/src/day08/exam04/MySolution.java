package day08.exam04;

public class MySolution {
	public int solution(String number) {
	int answer = 0;
    int result = 0;
      number="123";
        for(int i=0; i<number.length(); i++){
            result += (int)(number.charAt(i)-'0');
        }     answer = result%9;
    
    return answer;
	}
	
}
