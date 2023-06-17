package day10.exam02;
//ad제거하기
public class MySolution {
	public String[] solution(String[] strArr) {
               int count = 0;
               String[] str = new String[strArr.length];
        	   for(int i=0; i<strArr.length; i++) {
           if(!strArr[i].contains("ad")){
        	   count++;
        	   str[i] = strArr[i];
           }
           }
           String[] answer= new String[count];
           for(int i=0; i<count; i++) {
           answer[i]= str[i];
           }
           return answer;
	}
}
