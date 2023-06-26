package day07.exam03;

public class MySolution {
	public int[] solution(int start, int end) {
		   int[] answer = new int[end-start+1];
	        for(int i=0; i+start<=end; i++){
	            answer[i]=i+start;
	        }
	            
	        return answer;
    }

}
