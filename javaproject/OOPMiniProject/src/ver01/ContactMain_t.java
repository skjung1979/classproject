package ver01;

import java.util.Scanner;

//============ 강사님 문제 풀이 ================

public class ContactMain_t {
	
	
	public static void main(String[] args) {
		
		// contact 인스턴스 생성: 생성자를 이용한 데이터 초기화
		contact_t c1 = new contact_t("손흥민","010-1111-1111","s@gmail.com","런던",19991111,"가족");
		
		System.out.println("이름: " + c1.getName());
		System.out.println("연락처: " + c1.getPhoneNumber());
		System.out.println("이메일: " + c1.getEmail());
		System.out.println("주소: " + c1.getAddress());
		System.out.println("생일: " + c1.getBirthday());
		System.out.println("그룹: " + c1.getGroup());
		
		System.out.println();
		c1.printInfo();
		
		// 인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터를 수정한다.
		c1.setName("박지성");
		c1.setPhoneNumber("010-2222-2222");
		
		System.out.println();
		c1.printInfo();
		
		////////////////////////
		
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. 입력시작 | 0. 종료");
			String select = in.nextLine();
			if(select.equals("0"))
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}else if(!select.equals("1"))	// 범위를 벗어날 경우에 대한 설정
			{
				System.out.println("올바른 요청이 아닙니다. 1 or 0을 입력하세요.");
				continue;
			}
			
			System.out.println("데이터 입력을 시작합니다.");
			
			System.out.println("이름 >>> ");
			String name = in.nextLine();
			
			System.out.println("전화번호 >>> ");
			String phoneNumber = in.nextLine();
			
			System.out.println("이메일 >>> ");
			String email = in.nextLine();
			
			System.out.println("주소 >>> ");
			String address = in.nextLine();
			
			System.out.println("생일 >>> ");
			int birthday = in.nextInt();
			in.nextLine();
			System.out.println("그룹 >>> ");
			String group = in.nextLine();
			
			contact_t c = new contact_t(name, phoneNumber, email, address, birthday, group);
			
			c.printInfo();
		}	
	}
}





























