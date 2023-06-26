package day10.exam03;
//가까운 1찾기
public class MySolution {
	public int solution(int[] arr, int idx) {
		  int answer = 0;
	        int count = 0;
	        int[] result = new int[arr.length];
	        for(int i=0; i<arr.length; i++) {
	        if(i>=idx && arr[i]==1) {
	            result[count] = i;            
	        	count++;
	            answer= result[0];
	            break;
	        } else{
	            answer= -1;
	        }
	        }
	        return answer;
}
}
