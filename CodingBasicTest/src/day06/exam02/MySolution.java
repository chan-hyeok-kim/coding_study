package day06.exam02;

public class MySolution {
	 public int solution(int n, String control) {
	        int answer = 0;
	        for(int i=0; i<control.length(); i++) 
	        	switch(control.charAt(i)) {
	        	case 'w':
	        		n +=1;
	        		break;
	        	case 's':
	        		n -=1;
	        		break;
	        	case 'd':
	        		n +=10;
	        		break;
	        	case 'a':
	        		n -=10;
	        		break;
	        }   
	        answer = n;
			return answer;
}
}
