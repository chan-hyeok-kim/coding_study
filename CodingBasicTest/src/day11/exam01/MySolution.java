package day11.exam01;
//배열 만들기 3
public class MySolution {
	public int[] solution(int[] arr, int[][] intervals) {
	int[] result =  new int[arr.length*2];  
    int count = 0;
    for(int i=intervals[0][0]; i<=intervals[0][1]; i++){
        result[count] = arr[i];
        count++;
    }
    for(int i=intervals[1][0]; i<=intervals[1][1]; i++){
        result[count] = arr[i];
        count++;
    }
    int[] answer= new int[count];
    for(int i=0; i<count; i++){
        answer[i]= result[i];
    }
    //result 일반 정수 배열로
    return answer;
}
}