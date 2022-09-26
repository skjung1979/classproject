package chapter08.phone;

public class PhoneMain {

	public static void main(String[] args) {


		PhoneImpl phone1 = new PhoneImpl();
		phone1.call();

		
		SmartPhone2 smartPhone2 = new SmartPhone2("hot@gmail.com");
		
		smartPhone2.turnOn();
		smartPhone2.call();
		
		System.out.println();
		
		smartPhone2.appRun("카카오");
		System.out.println();
		smartPhone2.appStop("카카오");
		
		
		smartPhone2.turnOff();
		SmartPhone3 phone3 = new SmartPhone3("idd@");
		phone3.turnOn();
		phone3.call();
		phone3.appRun("네이버");
		phone3.appStop("네이버");
		phone3.turnOff();
		
		Phone phone01 = phone1;
		// 상위 타입인 Phone = 하위 타입인 PhoneImpl
	}

}
