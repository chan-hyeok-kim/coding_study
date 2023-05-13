package day03.exam04;

public class MySolution {
	public int solution(int a, int b) {
		
		        String a1= String.valueOf(a);
		        String b1= String.valueOf(b);
		        int answer;
		        String answer1 = a1 + b1;
		        String answer2 = b1 + a1;	
		        int c = Integer.parseInt(answer1);
		        int d = Integer.parseInt(answer2);
		        
		     	if(c>d) {
				  answer = c;
				 return answer;
				} if(c<d) {
				   answer = d;
				 return answer;
				} else{
					answer = c;
	            return answer;
	        }
    }
}

/*연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
12 ⊕ 3 = 123
3 ⊕ 12 = 312
양의 정수 a와 b가 주어졌을 때, a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.
단, a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다.  */
