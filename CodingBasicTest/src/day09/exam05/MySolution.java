package day09.exam05;
//할 일 목록
public class MySolution {
	public String[] solution(String[] todo_list, boolean[] finished) {
		String[] answer = {};
        String[] temp = new String[todo_list.length];

        int count = 0;
        for(int i=0; i<todo_list.length; i++){

            if(!finished[i]){
                temp[count] = todo_list[i];
                count++;
            }
        }

        answer = new String[count];
        for(int i=0; i<count; i++){
            answer[i] = temp[i];
        }
        return answer;
    }
}
    }
}
