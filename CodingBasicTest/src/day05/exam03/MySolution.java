package day05.exam03;

public class MySolution {
	 public int solution(int a, int b, int c) {
		 int answer = 0;
		 int A = a + b + c;
		 int B = (int) (a*a + b*b + c*c);
		 int C = (int) (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
		    
		 answer=(a==b && b==c) ?  A*B*C:A;
	        if((a==b && b!=c) || (a!=b && b==c)|| (a==c && c!=b)) 
	       	   answer=A*B;
	        return answer;
	    }
	       
}
