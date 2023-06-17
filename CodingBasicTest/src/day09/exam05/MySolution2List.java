package day09.exam05;

import java.util.ArrayList;
import java.util.List;

public class MySolution2List {
	public String[] solution(String[] todo_list, boolean[] finished) {
	          List<String> result = new ArrayList();
	    
	        		  for(int i=0; i<finished.length; i++) {
	        		  if(!finished[i]) { 
	        			  result.add(todo_list[i]);
	        		  }}
	        		  String[] answer = new String[result.size()];
	        		  
	        		  for(int i=0; i<result.size(); i++) {
	        		  answer[i] = result.get(i);
	        		 	 
	        		  }
					return answer;
	     
}
}