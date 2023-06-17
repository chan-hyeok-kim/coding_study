package day10.exam05;

//특별한 이차원 배열2

public class MySolution {
	public int solution(int[][] arr) {
        int answer = 0;
        int n=arr.length;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
    answer = (0<=i && j<n && arr[i][j]==arr[j][i]) ? 1 : 0; }}
        return answer;
    }
}
