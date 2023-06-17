package day11.exam02;

public class MySolution {
	public int[] solution(String[] intStrs, int k, int s, int l) {
		   String[] result = new String[intStrs.length];
	        int count = 0;
	        for(int i=0; i<intStrs.length; i++){
	            result[i]=intStrs[i].substring(s,s+l);
	            if(Integer.parseInt(result[i])>k){
	                result[count]=result[i];
	                count++;
	            }
	        }
	        int[] answer = new int[count];
	        for(int i=0; i<count; i++){
	            answer[i] = Integer.parseInt(result[i]);
	        }
	        return answer;

}
}