package DoItJava;

public class CalendarIn7 {
	
	private int[] month = new int[] {31,28,31,30,31,30,31,31,30,31,30,31}; // 평년
	private int[] lmonth = new int[] {31,29,31,30,31,30,31,31,30,31,30,31}; // 윤년

	public boolean leapYearTF(int year) {
		boolean yearTF = false;
		if ((year%4) == 0 && (year%100) != 0 || year%400 == 0) {
			yearTF = true;
		}
		return yearTF;
	}
	
	// 1~year까지 윤년 횟수 구하기
	public int howManyLeapYear(int year) {
		int count = 0;
		for (int i=1; i<= year; i++) {
			if (leapYearTF(i)) {
				count++;
			}
		}
		return count;
	}
	
	// 2005/9/25일이면 (2005/1/1~2005/8/31) 총 일수 + 25(9월)
	public int howManyDaysInYearsMonth(int year, int month, int day) {
		int count = day;
		;if (leapYearTF(year)) {
			for (int i=0; i<month-1; i++) {
				count += this.lmonth[i];
			}
		} else {
			for (int i=0; i<month-1; i++) {
				count += this.month[i];
			}
		}
		return count;
	}
	
	// 시작 날짜가 0->일 / 1->월 / 2->화 / 3->수 / 4->목 / 5->금 / 6->토
	public int startDayInCal(int year, int month) {
		int count = 0;
		int leapYear = howManyLeapYear(year-1);
		int howManyDaysInYear = howManyDaysInYearsMonth(year,month,1);
		count = ((leapYear)*2 + (year-1-leapYear) + howManyDaysInYear);
		return count%7;
	}
	
	public boolean isLastDay(int year, int month, int day) {
		boolean isL = false;
		if (!leapYearTF(year)) {
			if (day == this.month[month-1]) {
				isL = true;
			}
		} else {
			if (day == this.lmonth[month-1]) {
				isL = true;
			}
		}
		return isL;
	}
	
	public int getDates(int year, int month) {
		if (leapYearTF(year)) {
			return this.lmonth[month-1];
		} else {
			return this.month[month-1];
		}
	}
	
	public void printCalendar(int year, int month) {
		int linecheck = 0;
		String temp = "";
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		linecheck = startDayInCal(year, month);
		for (int j=0; j<linecheck; j++) {
			temp += "\t";
		}
		System.out.println(temp);
		
		int count = getDates(year, month);
		
		for (int i=1; i<= count; i++) {
			System.out.print(i + "\t");
			linecheck++;
			if (linecheck == 7) {
				if (this.isLastDay(year,  month,  i)) {
					return;
				}
				System.out.println();
				linecheck = 0;
			}
		}
	}
}





















