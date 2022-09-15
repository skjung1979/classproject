package MyProject_t;

import java.util.Scanner;

public class Member {
	
	public static void main(String[] args) {
		// class 파일의 실행 포인트
		
		printMyName("정성균");
		printMyName("sonny");
		
		System.out.println("chapter 01-2 종료");
		System.out.println();
		
		/* chapter 02-1
		 * 
		 * ① String 타입의 이름을 저장할 수 있는 변수 name을 정의해봅시다.
		 * ② int 타입의 나이를 저장할 수 있는 변수 age를 정의해봅시다.
		 * ③ double 타입의 키를 저장할 수 있는 변수 height를 정의해봅시다.
		 * ④ boolean 타입의 JAVA책의 보유 여부를 저장할 수 있는 변수 hasBook를 정의해봅시다.
		 * ⑤ 이름과 나이, 키, 책의 보유 여부를 출력해봅시다.
		 */
		
		Scanner in = new Scanner(System.in);
		
		
		String name = null; // 메소드 안에 있는 변수는 반드시 초기값을 넣어 주자(초기화)
		int age = 0; // 초기화
		String nickName = null; // 초기화
		double height = 0.0; // 초기화
		boolean hasBook = false; // 초기화
		
		System.out.print("이름을 입력해주세요. >>> ");
		name = in.nextLine();
		
		System.out.print("나이를 입력해주세요. >>> ");
		age = in.nextInt();
		
		in.nextLine(); // 이렇게 해 줘야 전 행(age)에서 입력한 값 뒤의 공백 공간을 뛰어 넘는다.
		// 뛰어 넘어야 다름 값을 받아서 입력 할 수있다.
		
		System.out.print("별명을 입력해주세요. >>> ");
		nickName = in.nextLine();
		
		System.out.print("키 정보를 입력해주세요. >>> ");
		height = in.nextDouble();
		
		System.out.print("책 보유 여부를 입력해주세요. >>> ");
		hasBook = in.nextBoolean();
		
		
		/*
		 * name = "정성균";
		 * age = 44;
		 * height = 173.8;
		 * hasBook = true;
		 */
		
		System.out.println("제 이름은 "+name+"입니다.");
		System.out.println("제 나이는 "+age+"세 입니다.");
		System.out.println("제 별명은 "+nickName+" 입니다.");
		System.out.println("제 키는 "+height+"cm 입니다.");
		System.out.println("자바책의 보유 여부: "+ hasBK(hasBook));
		
		
	}
	// chapter 01-2
	// 자기 자신의 이름을 출력하는 메소드
	// 반환타입: 없다면 -> void (메소드 안에서 바로 결과가 도출되는 경우)
	// 매개변수: 없다.
	// 처리내용: 자신의 이름을 출력한다.
	
	//아래 메소드 앞에 public static을 입력해야 메인메소드에서 호출이 가능하다.
	public static void printMyName(String name) {
				
		System.out.println("안녕하세요." + name + "입니다.");
		
		// 반환타입이 있다면 'return 변수명'을 기술한다.
		
	}
	
	public static String hasBK(boolean a) {
	  	    
	    if (a==true){
		String b = "갖고 있어요.";
		return b;
	    }else {
		String b = "아직 갖고 있지 않아요.";
		return b;
	    }
	}
	
}





























