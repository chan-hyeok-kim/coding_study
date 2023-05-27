package chap06.Object.ex22;

public class Ex22 {

	public static void main(String[] args) {
		String[] strArr = {"100", "200", "300"};
		
		System.out.println(concatenate("", "100","200","300"));
		System.out.println(concatenate("-",strArr));
		System.out.println(concatenate(",", new String[] {"1","2","3"}));
		System.out.println("["+concatenate(",", new String[0]+"]"));
		System.out.println("["+concatenate(",")+"]");

	}

	  static String concatenate(String delim, String...args) {
		  String result ="";
		  
		  for(String str : args) {
			  result += str +delim;
		  }
		  
		  return result;
	  }
	  
}
