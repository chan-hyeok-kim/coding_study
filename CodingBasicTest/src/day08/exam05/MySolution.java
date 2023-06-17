package day08.exam05;

public class MySolution {
	  public String solution(String my_string, int[][] queries) {
	        String answer = "";
	        String q1 = "";
	        for(int i=0; i<queries.length; i++) {
	        q1=my_string.substring(queries[i][0], queries[i][1]);
	        answer+=q1.charAt(q1.length()-i);
	       }
	            return answer;
	    }
}
