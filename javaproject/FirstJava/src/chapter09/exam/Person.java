package chapter09.exam;

import java.time.LocalTime;
import java.util.Date;

public class Person{

	String name;
	static String personNumber;
	
	
	public Person(String name, String personNumber) {
		super();
		this.name = name;
		this.personNumber = personNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
			
		if(obj != null && obj instanceof Person) {
			Person p = (Person)obj;
			result = this.personNumber.equals(Person.personNumber);
		}
		return result;
		
	}
	
	 
	
	public static void main(String[] args) {
	
		// 1. 위 Person 클래스의 equals() 메소드를 오버라이딩해서 주민등록번호가 같으면 인스턴스로 판별하는 프로그램을 만들어봅시다.
		Person p1 = new Person("정성균","790507-2222222");
	
		System.out.println("연습문제09-1번====================");
		System.out.println(p1.personNumber.equals("790507-1111111"));
	
		// 2. 1~100,000,000까지 더하기하는 연산의 실행 시간을 측정하는 프로그램을 만들어봅시다. 
		System.out.println("연습문제09-1번====================");
		
		Date now = new Date();
		
		long sTime = now.getTime();
		System.out.println("시작 밀리초: " + sTime);
		
		//시작시간을 밀리초
		int sum = 0;
		for(int i=0; i<=100000000; i++) {
			sum += i;
		}
		System.out.println("합계: "+sum);
		
		//끝난시간밀리초
		Date now2 = new Date();
		long eTime = now2.getTime();
		System.out.println("끝난 밀리초: " + eTime);
		
		System.out.println("1~100000000의 합계가 실행된 시간은: "+ (eTime-sTime)+"초");
		
		
		
		
		
		
		
		
		
	}
	
}
