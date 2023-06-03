package day09.exam01;

import java.util.ArrayList;
import java.util.List;
//순서 바꾸기
public class MySolution {
	public int[] solution(int[] num_list, int n) {
	int[] answer = new int[num_list.length];
	     List<Integer> listA = new ArrayList();
	       
     for(int i=n; i<num_list.length; i++) {
          listA.add(num_list[i]);
    }
	  for(int j=0; j<n; j++) {
	     listA.add(num_list[j]);
	  }
	  for (int i = 0; i < listA.size(); i++) {
          answer[i] = listA.get(i);
	  }
    return answer;
	
}
}