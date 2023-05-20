package day06.exam05;

public class MySolution {
	public int[] solution(int[] arr, int[][] queries) {
		
		 int[] answer = new int[queries.length];
	        
	        for (int i = 0; i < queries.length; i++) {
	            int q1 = queries[i][0];
	            int q2 = queries[i][1];
	            int q3 = queries[i][2];
	            
	            if (q1 >= arr.length || q2 >= arr.length) {
	                answer[i] = -1;
	                continue;
	            }
	            
	            int min = Integer.MAX_VALUE;
	            boolean found = false;
	            
	            for (int x = q1; x <= q2; x++) {
	                if (q3 < arr[x]) {
	                    if (arr[x] < min) {
	                        min = arr[x];
	                        found = true;
	                    }
	                }
	            }
	            
	            if (found) {
	                answer[i] = min;
	            } else {
	                answer[i] = -1;
	            }
	        }
	    return answer;
	}
}