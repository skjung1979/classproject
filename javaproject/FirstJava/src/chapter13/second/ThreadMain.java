package chapter13.second;

public class ThreadMain {

	// 메인 스레드 실행 시점
	public static void main(String[] args) {
		
		// 새로운 일의 흐름을 생성 => 스레드 생성
		MyThread thread1 = new MyThread(); // new 상태
		
		// 스레드의 실행: 흐름이 생성되고, run() 실행
		thread1.start();
		
		// Runnable 객체를 이용한 스레드 생성 실행
		MyThread2 t = new MyThread2();
		
		Thread thread2 = new Thread(t);
		
		// 스레드 실행
		thread2.start();
		//thread2.start(); // 오류: 스타트를 한번만!!!
		
		try {
			thread1.join(); // thread1이 종료될때까지 다른 스레드를 block상태로 처리
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		System.out.println("프로그램 종료");
	}
}
