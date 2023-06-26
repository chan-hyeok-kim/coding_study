package day10.exam01;
//X 사이의 개수
public class MySolution {
	 public int[] solution(String myString) {
		  String[] str=myString.split("x");
	     	String[] result=new String[str.length];
	        for(int i=0; i<str.length; i++){
	        	result[i] = str[i];
	        }
	        int[] answer = new int[result.length];
	        for(int i=0; i<result.length; i++){
	        	answer[i]=result[i].length();
          }
	        return answer;           
	 }
}
