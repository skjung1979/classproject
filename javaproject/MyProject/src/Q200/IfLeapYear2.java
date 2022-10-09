package Q200;

public class IfLeapYear2 {

	private int leapYear = 2022;
	
	public void setYear(int year) {
		leapYear = year;
	}
	
	public boolean isLeapYear() {
		boolean isLeap = false;
		if((leapYear%4)==0 && leapYear%100 != 0 || leapYear%400 == 0) {
			isLeap = true;
		}
		return isLeap;
	}
	
	public void prints() {
		if(isLeapYear()) {
			System.out.println(leapYear + "는 윤년 입니다.");
		}else {
			System.out.println(leapYear + "는 윤년이 아닙니다.");
		}
	}
	
	public static void main(String[] args) {
		
		IfLeapYear2 ly = new IfLeapYear2();
		
		ly.prints();
		
		ly.setYear(2023);
		ly.prints();
		ly.setYear(2024);
		ly.prints();
		
	}
	
}
