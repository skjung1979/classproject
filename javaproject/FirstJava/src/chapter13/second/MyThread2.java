package chapter13.second;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		
		for (int i=0; i<10; i++) {
			
			try {
				Thread.sleep(500); // 현재 스레드의 상태를 block상태로 변경
				
				System.out.println("Runnable 인터페이스를 이용한 스레드 생성과 작업이 진행됩니다.");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
