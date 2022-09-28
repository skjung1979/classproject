package chapter09.exam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exam09s4Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate birthDay = LocalDate.of(1979, 5, 7);
		LocalDate now = LocalDate.now();
		
		long days = ChronoUnit.DAYS.between(birthDay, now);
		System.out.println("내가 태어난지... ");
		System.out.println(days+"일");
		System.out.println(ChronoUnit.MONTHS.between(birthDay, now)+"개월");

		
		LocalDate sDay = LocalDate.of(2022, 12, 25);
		
		long days2 = ChronoUnit.DAYS.between(now, sDay);
		System.out.println("크리스마스까지 몇일?? "+days2);
		
	
		
	}

}
