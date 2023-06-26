package day10.exam01;

import java.util.Arrays;

public class My {
	 public int[] solution(String myString) {
		 String[] str = myString.split("x");
	        int count = str.length;
	        String[] result = new String[count];
	        
	for (int i = 0; i < count; i++) {
	    result[i] = str[i];
	}

	if (myString.endsWith("x")) {
	    count++;
	    result = Arrays.copyOf(result, count);
	    result[count - 1] = "";
	}

	int[] answer = new int[count];
	for (int i = 0; i < count; i++) {
	    answer[i] = result[i].length();
	}

	   
	 return answer;  
	}
}

