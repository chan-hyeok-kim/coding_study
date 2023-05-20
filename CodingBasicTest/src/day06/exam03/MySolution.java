package day06.exam03;

public class MySolution {
	public String solution(int[] numLog) {
        String answer = "";
        for(int i=2; i<numLog.length+1; i++)
           switch(numLog[i-1]-numLog[i-2]) {
	          case 1: 
        	      answer += 'w';
        	      break;
	          case -1: 
	        	  answer += 's';
	        	  break;
	          case 10: 
	        	  answer += 'd';
	        	  break;
	          case -10: 
	        	  answer += 'a';
	        	  break;
           }
	         return answer;
    }
	
}
