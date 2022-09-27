package chapter09;

public class Car extends Object {

	String name;
	
	Car(String name){
		this.name = name;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		// String의 경우 equals로 비교하면 보기에 같아도 해쉬코드가 달라서 다르다고 나오는데,
		// 아래처럼하면 보이는 문자 그대로 같은지를 판단하는 코드가 된다.
		// 오버라이딩을 통해 보여지는 문자 그대로 같은지를 체크하는 코드
		boolean result = false;

		if(obj != null && obj instanceof Car) {
			Car car = (Car)obj;
			result = this.name.equals(car.name);
		}
		return result;
	}


	//	@Override
//	public String toString() {
//		
//		return name; // super.toString(); 지우고
//	}
	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}
	
	

	public static void main(String[] args) {
		
		Car car1 = new Car("BMW");
		Car car2 = new Car("쏘렌토");
		
		System.out.println(car1);	// 결과: 클래스의 풀네임@16진수 <- toString()가 정의했기 때문에.
		// System.out.println(car1.hashCode());
		System.out.println(car2);
		
		System.out.println("car1 == car2 ==>> " + (car1 == car2));
		System.out.println("car1.equals(car2) ==>> " + car1.equals(car2));
		// Object클래스의 equals() 메소드는 참조값 비교하고 결과를 반환 정의
		
		if(car1.equals(car2)) {
			System.out.println("같은 차종입니다.");
		}else {
			System.out.println("서로 다른 차종입니다.");
		}
		
		
	}

	
}
