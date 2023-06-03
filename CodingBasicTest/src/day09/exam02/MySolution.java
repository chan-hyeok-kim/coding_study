package day09.exam02;

//접미사 배열
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySolution {
	    public String[] solution(String my_string) {
	    	String[] answer = new String[my_string.length()];
	        List<String> result= new ArrayList();
	        for(int i=0; i<my_string.length(); i++) {
	        	result.add(my_string.substring(i)); 
	        }
	        Collections.sort(result);
	        for(int i=0; i<result.size(); i++) {
	        	answer[i] = result.get(i);
	        }  	
	        return answer;       
	    }
}

