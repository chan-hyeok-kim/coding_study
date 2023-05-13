package day02.exam05;

public class MySolution {
	 public String solution(String my_string, String overwrite_string, int s) {
		      
		 StringBuilder answer = new StringBuilder();
		 int num = my_string.length()-s-overwrite_string.length();
		 
		 for(int i=0; i<=s-1; i++) {
			answer.append(my_string.charAt(i));}
		    answer.append(overwrite_string);
		    for (int i = 0; i < num; i++) {
	            answer.append(my_string.charAt(i + s + overwrite_string.length()));
	        }
		    return answer.toString();
			  } 
         }	 

/*문자열 my_string, overwrite_string과 정수 s가 주어집니다.
문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을 
문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.*/
//String a = my_string[0, s-1] + overwrite_string.length + [s]