package chapter07.exam;

import java.time.LocalDate;
import java.util.Calendar;

public class Person {

//	Person 이라는 클래스를 정의해봅시다. 
//	① 이름을 저장하는 변수,
// 주민등록번호를 저장하는 변수를 정의해봅시다.
//	② 인사하는 메소드를 정의해봅시다.
//	- “안녕하세요. 저는 OOO입니다. 00살 입니다.”라는 문자열이 출력하도록 정의합시다.

	String name;
	String personNumber;
	
	public Person(String name, String personNumber) {
		super();
		this.name = name;
		this.personNumber = personNumber;
	}
	
	// 나이를 반환하는 메소드, 주민 번호는 personNumber값을 이용해서 처리!
	int getAge() {
		
		int result = 0;
		
		// 나이를 계산해서 반환하는 연산
		// 001212-1111111
		// 990203-2222222
		String tempYear = personNumber.substring(0, 2) ; // "00", "99"를 뽑아내는 방법은?
		String tempGender = personNumber.substring(7, 8);
		
		// 00 -> 2000년생 이상 -> 년도 => "00" -> int + 2000
		// 99 -> 1900년생 이상 -> 년도 => "99" -> int + 1900
		
		// Interger.parseInt("문자열"); int 정수 반환
		
		// 나이 구하기: 올해 년도 - 태어난 년도
		// int curYear = Calendar.getInstance().get(Calendar.YEAR); 현재 년도 뽑는 방법1
		int curYear = LocalDate.now().getYear();
		
		int birthYear = Integer.parseInt(tempYear);
		int genderVal = Integer.parseInt(tempGender);
		
		if(genderVal == 1 || genderVal == 2) {
			result = 1900 + birthYear;
		}else if(genderVal == 3 || genderVal == 4) {
			result = 2000 + birthYear;
		}
		
		return curYear - result +1;
	}
	
	
	void printInfo() {
		
		System.out.printf("안녕하세요. 저는 %s 입니다. %d살 입니다.", this.name, getAge());
	}

}






















