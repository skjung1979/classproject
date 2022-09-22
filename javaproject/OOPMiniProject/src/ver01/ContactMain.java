package ver01;

import java.util.Scanner;

//public 지우면 패키지에서만 사용됨
class ContactMain
{

	public static void main(String[] args)
	{
	
		String nm = null;
		String pn = null;
		String em = null;
		String ad = null;
		int bd = 00000000;
		String gr = null;
		
		Contact c1 = new Contact(nm, pn, em, ad, bd, gr);
		
		while(true)
		{
					
			System.out.println("-----------------------");
			System.out.println("원하는 항목을 싶은 항목을 선택하세요...");
			System.out.println("0.전체입력/1.이름/2.전화번호/3.이메일/4.주소/5.생일/6.그룹/7.종료");

			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			scan.nextLine();

			// 연락처 데이터를 저장하는 인스턴스를 생성합니다.		
			// Contact c1 = new Contact(nm, pn, em, ad, bd, gr); // 이게 여기 있으면 수정할때 변경하지 않은 변수들이 null이 되어 버림
			
			if (n == 0) {
	
				System.out.println("사용자의 정보를 입력하세요....");

				System.out.print("이름: ");
				c1.setName(scan.nextLine());
				
				System.out.print("전화번호: ");
				c1.setPhoneNumber(scan.nextLine());

				System.out.print("이메일: ");
				c1.setEmail(scan.nextLine());

				System.out.print("주소: ");
				c1.setAddress(scan.nextLine());

				System.out.print("생일: ");
				c1.setBirthday(scan.nextInt());
				scan.nextLine();
				System.out.print("그룹: ");
				c1.setGroup(scan.nextLine());

				// getter 에의한 정보 출력
				System.out.println("getter에 의한 정보 출력----");
				System.out.println(c1.getName());
				System.out.println(c1.getPhoneNumber());
				System.out.println(c1.getEmail());
				System.out.println(c1.getAddress());
				System.out.println(c1.getBirthday());
				System.out.println(c1.getGroup());
				
				c1.print();

			} else if (n == 1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6) {
			
				switch (n) {
				case 1:
					System.out.print("변경할 이름은? ");
					c1.setName(scan.nextLine());
					break;
				case 2:
					System.out.print("변경할 전화번호는? ");
					c1.setPhoneNumber(scan.nextLine());
					break;
				case 3:
					System.out.print("변경할 이메일은? ");
					c1.setEmail(scan.nextLine());
					break;
				case 4:
					System.out.print("변경할 주소는? ");
					c1.setAddress(scan.nextLine());
					break;
				case 5:
					System.out.print("변경할 생일은(숫자)? ");
					c1.setBirthday(scan.nextInt());
					scan.nextLine();
					break;
				case 6:
					System.out.print("변경할 그룹은? ");
					c1.setGroup(scan.nextLine());
					break;
				case 7:
					System.out.print("종료합니다~ bye~!");
					break;
				}
				
				c1.print();
				
			} else if(n==7)
			{
				break;
			}
		}
	}
}
























