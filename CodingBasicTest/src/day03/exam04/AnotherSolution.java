package day03.exam04;

public class AnotherSolution {
	    public int solution(int a, int b) {
	        int c = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
	        int d = Integer.parseInt(String.valueOf(b) + String.valueOf(a));
	        
	        return Math.max(c, d);
	    
	}         //내가 쓸 때 길게 썼던 4번 예제를 Math.max를 쓰면 훨씬 간추릴 수도 있었다.
}

