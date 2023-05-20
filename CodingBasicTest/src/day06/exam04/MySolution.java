package day06.exam04;

public class MySolution {
	public int[] solution(int[] arr, int[][] queries) {
		
        int[] answer = new int[arr.length];
        int tmp= 0;
        
        for(int i=0; i<queries.length; i++) {
        	    int q1=queries[i][0];
        	    int q2=queries[i][1];
        	    tmp=arr[q1];
                arr[q1]=arr[q2];
                arr[q2]=tmp;
        }
        answer=arr;
        return answer;
        }
        
}
