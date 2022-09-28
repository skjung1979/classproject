package chapter09.exam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Person{

	String name;
	String personNumber;
	
	
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
			result = this.personNumber.equals(p.personNumber);
		}
		return result;
		
	}
	
	 
	
	public static void main(String[] args) {
	
		// 1. 위 Person 클래스의 equals() 메소드를 오버라이딩해서 주민등록번호가 같으면 인스턴스로 판별하는 프로그램을 만들어봅시다.
		Person p1 = new Person("정성균","790507-2222222");
	
		System.out.println("연습문제09-1번====================");
		System.out.println(p1.personNumber.equals("790507-1111111"));
	
		System.out.println();
		// 2. 1~100,000,000까지 더하기하는 연산의 실행 시간을 측정하는 프로그램을 만들어봅시다. 
		System.out.println("연습문제09-1번====================");
		
	
		long sTime = System.currentTimeMillis();
		System.out.println("시작 밀리초: " + sTime);
		
		//시작시간을 밀리초
		int sum = 0;
		for(int i=1; i<=100000000; i++) {
			sum += i;
		}
		System.out.println("합계: "+sum);
		
		//끝난시간밀리초
		long eTime = System.currentTimeMillis();
		System.out.println("종료 밀리초: " + eTime);
		
		System.out.println("1~100000000의 합계가 실행된 시간은: "+ (eTime-sTime)+"밀리초");
		
		System.out.println();
		// 3. 사용자에게 이름을 입력 받아 입력 받은 문자열을 정상적인 문자열의 이름으로 표현하는지 판별하고, 공백으로 입력되었는지도 판별하는 프로그램을 만들어봅시다. 
		System.out.println("연습문제09-3번====================");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요. >>> ");
		String name = scan.nextLine();
		
		if(name.trim().isEmpty()) {
			System.out.println("이름은 넣으셔야 합니다~");
		}else {

			if(checkName(name)) {
				System.out.println(name);
			}else {
				System.out.println("이름은 영문자 대소문자만 입력이 가능힙니다.");
			}
			
		}
		
		
		
		System.out.println();
		// 4. 자신의 생일을 기준으로 오늘까지 몇 일을 살았는지 출력하는 프로그램을 만들어봅시다.
		System.out.println("연습문제09-4번====================");
		LocalDate birthDay = LocalDate.of(1979, 6, 1);
		LocalDate now = LocalDate.now();
		
		long days = ChronoUnit.DAYS.between(birthDay, now);
		System.out.println("내가 태어난지... ");
		System.out.println(days+"일");
		
		
		
	}
		static boolean checkName(String name) {
			boolean result = true;
			
			for(int i=0; i<name.length();i++) {
				char c = name.charAt(i);
				if(!(c>='a' && c<='z' || c>='A' && c <= 'Z')) {
					result = false;
					break;
				}
			}
			return result;
		
		}
		
		
		
		
		
		
		
	
	
}
