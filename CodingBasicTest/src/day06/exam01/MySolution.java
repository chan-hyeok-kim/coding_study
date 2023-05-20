package day06.exam01;

public class MySolution {
	public int[] solution(int[] num_list) {
		int n=num_list.length;
        int[] answer= new int[n+1];
        
        for(int i=0; i<num_list.length; i++) {
        	answer[i] = num_list[i];  
        	}
        if(num_list[n-2]<num_list[n-1]) {
        	answer[n] = num_list[n-1]-num_list[n-2];
       }else {
    	answer[n] = num_list[n-1]*2;
    }
       return answer;
}
}
