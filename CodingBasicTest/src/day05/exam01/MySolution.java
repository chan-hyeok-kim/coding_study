package day05.exam01;

public class MySolution {
	 public String solution(String code) {
		    String answer = "";
	        int mode = 0;
	        

	    for (int i = 0; i < code.length(); i++) {
	            char c = code.charAt(i);
	        
	     if(c!='1' && i%2==0 && mode==0){
	   answer+= c;} else if(c=='1'){
	             mode=1;
	    
	                
	}
	     Loop: for(i=0; i< code.length(); i++){
	           c = code.charAt(i);
	          
	            if(c!='1' && i%2!=0 && mode==1){
	answer+= c;} else if(c=='1'){
	                mode=0;
	                break Loop;
	        }}
	    }
	        if (answer.equals("")) {
	        	answer = "EMPTY";
	        }
	        return answer;
	    }
}
