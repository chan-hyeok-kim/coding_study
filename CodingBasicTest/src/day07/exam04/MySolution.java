package day07.exam04;

import java.util.ArrayList;

public class MySolution {
	  public int[] solution(int n) {
	        int[] answer = new int[n];
	        ArrayList<Integer> answerList = new ArrayList<>();
	        answerList.add(n);
	        while (n != 1) {
	            
	            if (n % 2 == 0) {
	                answerList.add(n / 2);
	            } else {
	                answerList.add(3 * n + 1);
	            }
	            n = answerList.get(answerList.size() - 1); // 다음 반복에서 n 값으로 사용하기 위해 갱신
	        }

	        answer = new int[answerList.size()];
	        for (int i = 0; i < answerList.size(); i++) {
	            answer[i] = answerList.get(i);
	        }
	        return answer;
	}
}
