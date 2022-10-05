package Q200;

public class CarMain {

	public static void main(String[] args) {
		
		Car car1 = new Car();
		car1.speedUp();
		car1.speedDown();
		car1.speedUp();
		System.out.println("현재 스피드: "+car1.curSpeed());
		car1.turnDirect(-30);
		car1.turnDirect(10);
		System.out.println("현재 방향: "+car1.curDirect());
	}

}
