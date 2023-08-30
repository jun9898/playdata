package assignment;

public class Prob1{

public static void main(String[] args) {
	Truck truck = new Truck("트럭", 50, 4);
	Bike bike = new Bike("자전거", 10, 2);
	System.out.println(truck.carName + 
		" : 바퀴 " + truck.wheelNumber + "개입니다");
	System.out.println(bike.carName +
		" : 바퀴 " + bike.wheelNumber + "개입니다");	
//	wheelers[1] = bike;	
	for(int i = 0; i < 2; i++){
		truck.speedUp(10);
		bike.speedUp(15);
		truck.speedDown(20);
		bike.speedDown(25);	
		truck.stop();
		bike.stop();		
	}
}
}

