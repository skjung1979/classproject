package chapter13;

// 스레드 클래스 정의: thread클래스를 상속받아 run()메소드를 오버라이딩
public class MyThread extends Thread {

	@Override
	public void run() { // 스레드의 메인 메소드 개념
		// System.out.println("새로운 스레드가 생성되어 실행합니다. Thread의 run()을 오버라이딩!");
		// 메인 메소드에서 인스턴스 생성 하고, start()메소드 호출 해야 한다.

		for (int i = 0; i < 10; i++) {
			System.out.println("새로운 스레드가 생성되어 실행합니다. Thread의 run()을 오버라이딩!");
//			
//			
//			try {
//				Thread.sleep(500); // 0.5초
//				System.out.println("새로운 스레드가 생성되어 실행합니다. Thread의 run()을 오버라이딩!");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}		
//			
		}
	}
}
