package chapter05.exam;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		// ④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력
		// 두 가지 생성자를 이용해 인스턴스 생성: 이름, 전화번호, 전공, 학년, email, 생일, 주소
		System.out.println("회원 정보를 입력하세요.");
		System.out.print("이름: >>> ");
		String name = scan.nextLine();
		
		System.out.print("전화번호: >>> ");
		String phoneNM = scan.nextLine();
		
		System.out.print("전공: >>> ");
		String major = scan.nextLine();
		
		System.out.print("학년: >>> ");
		int grade = scan.nextInt();
		scan.nextLine(); // 키보드 값을 입력 받을때 위줄에 .nextInt()이 있으면 꼭 이렇게 한줄을 입력해줘야한다.
		System.out.print("이메일: >>> ");
		String email1 = scan.nextLine();
		
		System.out.print("생일: >>> ");
		String birthDay = scan.nextLine();
		
		System.out.print("주소: >>> ");
		String address = scan.nextLine();
		
		
		// .equals("")로 비교하거나 == null 로 찾아내기
		System.out.println();
//		int a = birthDay.length();
//		boolean b = birthDay == null ? true: false;
//		System.out.println(a);
//		System.out.println(email1.length());
		
		if((birthDay.equals("") || birthDay == null) && (address.equals("") || address == null))
		{
		// 두번째 생성자를 이용해 인스턴스 생성: 이름, 전화번호, 전공, 학년, email / 생일과 주소는 입력하지 않을 때
		System.out.println("--<생일,주소 제외한 정보들>를 표시하는 인스턴스 생성--");
		//Member mem2 = new Member(name,phoneNM,major,grade,email1);
		Member mem2 = new Member(name,phoneNM,major,grade,email1);
		mem2.showInfo();
		
	
		}else
		{
			System.out.println("-----<모든 정보>를 표시하는 인스턴스 생성-----");
			//Member mem1 = new Member(name,phoneNM,major,grade,email1,birthDay,address);
			Member mem1 = new Member(name,phoneNM,major,grade,email1,birthDay,address);
			mem1.showInfo();
			
		}

		
		
		
	}

}
