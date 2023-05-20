package day05.exam05;

public class MySolution {
	public int solution(int[] num_list) {
        int answer = 0;
        String a=""; 
        String b="";
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<num_list.length; i++) {
        if(num_list[i]%2==0) {
        	a+=num_list[i];}
        else {
        	b+=num_list[i];
        }
        }
        answer= Integer.parseInt(a)+Integer.parseInt(b);
        return answer;
    }
}






