package day04.exam04;

public class MySolution {
	public int solution(String ineq, String eq, int n, int m) {
		 if (n < m && ineq.equals("<")) {
		        return 1;
		    } else if (n == m && eq.equals("=")) {
		        return 1;
		    } else if (n > m && ineq.equals(">")) {
		        return 1;
		    } else {
		        return 0;
		    }
		}
	}


  