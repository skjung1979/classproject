package chapter07.exam;

import java.time.LocalDate;

public class PersonSK {
	
	String name;
	String personNumber;
	
	public PersonSK(String name, String personNumber) {
		super();
		this.name = name;
		this.personNumber = personNumber;
	}
	
	int getAge() {
		
		int result = 0;
		
		String tmpYear = personNumber.substring(0, 2);
		String tmpGender = personNumber.substring(7,8);
		
		int curYear = LocalDate.now().getYear();
		
		int birthYear = Integer.parseInt(tmpYear);
		int genderVal = Integer.parseInt(tmpGender);
				
		if(genderVal == 1 || genderVal ==2) {
			result = 1900 + birthYear; 
		}else if(genderVal == 3 || genderVal == 4) {
			result = 2000 + birthYear;
		}
		return curYear - result + 1;
		
	}
	
	void printInfo() {
		System.out.printf("안녕하세요.저는 %s입니다. %d살 입니다.", this.name, getAge());
	}
	

}
