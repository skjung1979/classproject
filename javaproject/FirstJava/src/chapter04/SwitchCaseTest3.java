package chapter04;

public class SwitchCaseTest3 {

	public static void main(String[] args) {
		
		
		// ========= switch case문과 if문 비교===========
		// 아래 경우는 switch case문의 더 가독성이고 간단하다.
		
		String grade = "admin";
		// admin / manager / member / anyone
		
		// 쓰기 / 읽기 / 회원 승인 / 지표 보기
		if(grade.equals("admin"))
		// String 객체에서 equal()메소드를 사용한다.
		// -> 문자를 비교하는 메소드 반환값은 true 또는 false이다.
		{
			System.out.println("지표보기 기능 가능합니다.");
			System.out.println("회원승인 가능합니다.");
			System.out.println("쓰기 기능 가능합니다.");
			System.out.println("읽기 기능 가능합니다.");
		}else if(grade.equals("manager"))
		{
			System.out.println("회원승인 가능합니다.");
			System.out.println("쓰기 기능 가능합니다.");
			System.out.println("읽기 기능 가능합니다.");
		}else if(grade.equals("member"))
		{
			System.out.println("쓰기 기능 가능합니다.");
			System.out.println("읽기 기능 가능합니다.");
		}else if(grade.equals("anyone"))
		{
			System.out.println("읽기 기능 가능합니다.");
		}
		
		// switch case 사용하고 break를 생략하면 아래와 같이 단순하게 기술 가능하다.
		switch(grade)
		{
		case "admin":
			System.out.println("지표보기 기능 가능");
		case "manager":
			System.out.println("회원승인 가능");
		case "member":
			System.out.println("쓰기 기능 가능");
		case "anyone":
			System.out.println("읽기 기능 가능");
		}	
	}
}
