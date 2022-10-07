package chapter13;

public class SumThread extends Thread{

	Sum s;
	long num1;
	long num2;
	
	public SumThread(Sum s, long num1, long num2) {
		super();
		this.s = s;
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public void run() {
		
		for(long i=num1; i<=num2; i++) {
			
			s.sum(i);	
		}
	}
	
	public static void main(String[] args) {
		
		// 합의 데이터를 저장하고, 합 연산을 하는 메소드가 정의된 객체
		Sum sum = new Sum();
		
		SumThread t1 = new SumThread(sum, 1, 50000);
		SumThread t2 = new SumThread(sum, 50001, 1000000);
		
		t1.start(); // 이 작업에 대한 시간을 보장(join())해줘야 정상적인 연산이 된다.
		t2.start(); // t1의 작업이 끝나기 전에 t2이 실행되면..
					// join()로 t2를 보장하더라도 t2의 값을 sum()에 할당한다.
					// 그래서 합계 연산의 결과가 유효하지 않다. 할때마다 다른 결과 나옴.
					// 그러면 공동으로 사용 중인 sum()에서 synchronized 키워드를 넣어주면 된다.!!!
					// 동기화 하면 성능 저하가 올 수 있다.
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("합 : " + sum.sum);
	}
}

class Sum{ // 이게 동시에 접속하는 동기화되는 클래스이다. => 동시에 할 경우 유효한 값이 안 나온다.
	
	long sum;
	
	// 동기화 처리 키워드 하지만,,, 성능 저하가 올 수도 있다.
	synchronized void sum(long num) {
		sum += num;
	}
}




















