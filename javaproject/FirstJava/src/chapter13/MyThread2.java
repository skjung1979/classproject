package chapter13;

// Runnable 인터페이스를 상속 받았음
public class MyThread2 implements Runnable {

	@Override
	public void run() {

		// System.out.println("Runnable인터페이스를 이용한 스레드 생성과 작업이 진행됩니다.");

		for (int i = 0; i < 10; i++) {

			System.out.println("Runnable인터페이스를 이용한 스레드 생성과 작업이 진행됩니다.");
//			
//			try {
//				Thread.sleep(500); // 현재 스레드의 상태를 block상태로 변경, 500은 1000분의 1초 > 0.5초
//				System.out.println("Runnable인터페이스를 이용한 스레드 생성과 작업이 진행됩니다.");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} 
//			
		}
	}
}
