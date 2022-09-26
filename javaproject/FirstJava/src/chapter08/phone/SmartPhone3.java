package chapter08.phone;

public class SmartPhone3 extends Computer implements SmartDevice {

	boolean power;
	
	SmartPhone3(String account) {
		super(account);
		this.power = false;
	}

	@Override
	public void call() {
		// 119에 전화를 합니다.
		// 상수를 이용해서 번호를 만들고 출력합니다.
		
		String number1 = String.valueOf(Phone.PHONE_NUM_1);
		String number9 = String.valueOf(Phone.PHONE_NUM_9);
		
		System.out.println(number1+number1+number9+"에 전화를 합니다~ 불이야~");
		
		// System.out.println(Phone.PHONE_NUM_1+Phone.PHONE_NUM_1+Phone.PHONE_NUM_9);
	}
	
	@Override
	public void turnOn() {
		
		// true: 전원이 켜진 상태
		// false: 전원이 꺼진 상태
		if(!power) {
			power = true;
		}
	}
	
	@Override
	public void turnOff() {
		if(!power) {
			power = false;
		}
	}
	
	public static void main(String[] args) {
		SmartPhone3 phone = new SmartPhone3("cool@gmail.com");
		
		phone.call();
		phone.calculator();
		
	}

	@Override
	public void appRun(String appName) {

		System.out.println(appName+"앱을 실행합니다.");
		
	}

	@Override
	public void appStop(String appName) {
		System.out.println(appName+"앱을 종료합니다.");
		
	}
	
}



















