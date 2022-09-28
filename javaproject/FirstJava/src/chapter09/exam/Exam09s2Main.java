package chapter09.exam;

public class Exam09s2Main {
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		System.out.println("시작 시간: " + startTime);
		
		int sum = 0;
		for(int i=1; i<=100000000; i++) {
			sum += i;
		}
		System.out.println("1~100000000의 합은? "+ sum);
		
		long endTime = System.currentTimeMillis();
		System.out.println("종료 시간: " + endTime);
		
		System.out.println("연산의 소요 시간: " + (endTime-startTime));
		
	}
	

}
