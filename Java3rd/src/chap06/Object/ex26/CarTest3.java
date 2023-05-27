package chap06.Object.ex26;

class Car {
	String color;
	String gearType;
	int door;
	
	Car(){
		this("white", "auto", 4);
	}
	
	Car(Car c){
		color  = c.color;
		gearType = c.gearType;
		door  = c.door;
	}
	Car(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

public class CarTest3 {
   public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car(c1);
		
		System.out.println("c1의 color=" + c1.color + ",gearType=" + c1.gearType+", door ="+ c1.door);
		System.out.println("c2의 color=" + c2.color + ",gearType=" + c2.gearType+", door ="+ c2.door);
        c1.door = 100;
        System.out.println("c1.door=100; 수행 후");
        System.out.println("c1의 color=" + c1.color + ",gearType=" + c1.gearType+", door ="+ c1.door);
		System.out.println("c2의 color=" + c2.color + ",gearType=" + c2.gearType+", door ="+ c2.door);
     
	}

}
