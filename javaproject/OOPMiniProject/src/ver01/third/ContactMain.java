package ver01.third;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("1. 입력   |   0. 종료");
			String select = in.nextLine();

			if (select.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else if(!select.equals("1")) {
				System.out.println("올바른 요청이 아닙니다. 1, 0중에 선택 해 주세요.");
				continue;		
			}
		
		System.out.println("데이터 입력을 시작합니다.");
		
		System.out.print("이름: >>> ");
		String name = in.nextLine();
		
		System.out.print("전화번호: >>> ");
		String phoneNumber = in.nextLine();
		
		System.out.print("이메일: >>> ");
		String email = in.nextLine();
		
		System.out.print("주소: >>> ");
		String address = in.nextLine();
		
		System.out.print("생일: >>> ");
		String birthday = in.nextLine();
		
		System.out.print("그룹: >>> ");
		String group = in.nextLine();
		
		Contact c = new Contact(name, phoneNumber, email, address, birthday, group);
		
		c.printInfo(); // 입력 받은 결과 호출
		}	
	}
}
