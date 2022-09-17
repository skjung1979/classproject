package Q200;

import java.util.Calendar;

public class IfLeapYear {

	public static void main(String[] args) {
		// 윤년과 윤년이 아닌 해를 구분한다.
		// 1979년 부터 2022년까지 각 연도에 윤년 여부를 표시한다.
		
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		
		boolean leapYearTF;
		
		System.out.println("1979년도 부터 현재까지 윤년인 해는 아래와 같습니다.");
		for(int year=1979; year<=curYear; year++)
		{
			if(((year%4)==0 && (year%100) != 0) || (year%400==0))
			{
				leapYearTF = true;
				int leapYear = year;
				//System.out.println(year+"년도는 윤년입니다.");
				System.out.print(leapYear+"\b");
			}else
			{
				leapYearTF = false;
				//System.out.println(year+"년도는 윤년이 아닙니다.");
			}
			
			
			
			
		}
		

	}

}
