package chap06.Object.ex23;


	class Data1 {
		int value;
	}
class Data2{
	int value;
	
	Data2(int x){
		value = x;
	}
}

class ConstructorTest{
	public static void main(String[] args) {
		Data d1 = new Data();
		Data2 d2 = new Data2();
	}
}

}
