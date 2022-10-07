package chapter13;

public class ThreadMain {
	
	// 메인 스레드 실행 시점
	public static void main(String[] args) {
		
		// 새로운 일의 흐름을 생성 -> 스레드 생성
		MyThread thread1 = new MyThread(); // new 상태
		
		// 스레드의 실행 -> 스레드 클래스의 run() 블록 안의 내용들이 실행됨.
		thread1.start();
		
		// Runnable 객체를 이용한 스레드 생성 실행
		MyThread2 t = new MyThread2();
		Thread thread2 = new Thread(t); // 이렇게 Thread를 인스턴스 생성해서 MyThread2타입 t를 받아야 함.
		
		// 스레드 실행 
		thread2.start();
		// thread2.start(); // start()는 한번만 하면 된다! 두번 하면 에러남!
		
		try {
			thread1.join(); // thread1이 종료 될 때까지 다른 스레드를 block상태로 만든다. 그러면 메인 메소드에서도 아래 행으로 작업 진행 안됨.
			thread2.join(); // 상동
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		System.out.println("프로그램 종료"); // 여기가 메인의 종료시점이지만, 스레드는 별도로 작동한다. 
		// 하지만 join()메소드를 이용하면 스레드들이 종료 될때까지 메인메소드의 작업 진행을 잡아둘수 있다.

	}

}
