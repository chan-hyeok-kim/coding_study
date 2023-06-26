package day09.exam03;
//배열의 원소 삭제하기
public class MySolution {
	public int[] solution(int[] arr, int[] delete_list) {
          int count = 0;
          int[] n= new int[arr.length];
        for(int i=0; i<delete_list.length; i++) {
        for(int j=0; j<delete_list.length; j++) {
        	if(arr[i]== delete_list[j]) {	
        		n[count]=arr[i];
        		count++;
        	}
        }
        }
        int[] answer = new int[arr.length-count]; 
        int count2 = 0;
        for(int i=0; i<arr.length; i++) {
        	if(count2<count && arr[i] == n[count2]) {
        		count2++;
        	}else{
                 answer[i - count2] = arr[i];
            }}
        return answer;
}
}
