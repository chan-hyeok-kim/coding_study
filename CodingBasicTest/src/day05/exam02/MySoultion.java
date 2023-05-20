package day05.exam02;

public class MySoultion {
	public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int n=included.length;
        int[] result= new int[n];
        int i;
        
        for(i=0; i<n; i++) { 
        	result[i] = a+i*d;
        if(included[i]) {
             answer += result[i];
        }
        }   
        return answer;
}
}