package day11.exam01;

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int[] interval : intervals) {
            for (int i = interval[0]; i <= interval[1]; i++)
                arrayList.add(arr[i]);
        }
        //알것도 같다. 첫번째 for반복문에서 인터벌에 인터벌스가 2번 들어가는거야 
        //2번 실행되는거지.
        //좀 신기하네
        int idx = 0;
        int[] answer = new int[arrayList.size()];
        for (int data : arrayList)
            answer[idx++] = data;
        return answer;
    }
}
