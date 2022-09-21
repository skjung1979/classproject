package ver01;

import java.util.Scanner;

public class ContactMain
{

	public static void main(String[] args)
	{
	
		while(true)
		{
					
			System.out.println("-----------------------");
			System.out.println("원하는 항목을 싶은 항목을 선택하세요...");
			System.out.println("0.전체입력/1.이름/2.전화번호/3.이메일/4.주소/5.생일/6.그룹/7.종료");

			Scanner scan = new Scanner(System.in);

			int n = scan.nextInt();
			scan.nextLine();

			// 연락처 데이터를 저장하는 인스턴스를 생성합니다.
			String nm = null;
			String pn = null;
			String em = null;
			String ad = null;
			int bd = 00000000;
			String gr = null;
		
			if (n == 0) {

				Contact c1 = new Contact(nm, pn, em, ad, bd, gr);
				
				System.out.println("사용자의 정보를 입력하세요....");

				System.out.print("이름: ");
				nm = scan.nextLine();

				System.out.print("전화번호: ");
				pn = scan.nextLine();

				System.out.print("이메일: ");
				em = scan.nextLine();

				System.out.print("주소: ");
				ad = scan.nextLine();

				System.out.print("생일: ");
				bd = scan.nextInt();
				scan.nextLine();
				System.out.print("그룹: ");
				gr = scan.nextLine();

				c1.print();

				// getter 에의한 정보 출력
				System.out.println("getter에 의한 정보 출력----");
				System.out.println(c1.getName());
				System.out.println(c1.getPhoneNumber());
				System.out.println(c1.getEmail());
				System.out.println(c1.getAddress());
				System.out.println(c1.getBirthday());
				System.out.println(c1.getGroup());

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
					System.out.print("변경할 생일은? ");
					c1.setBirthday(scan.nextInt());
					break;
				case 6:
					System.out.print("변경할 그룹은? ");
					c1.setGroup(scan.nextLine());
					break;
				case 7:
					System.out.print("종료합니다~ bye~!");
					break;
				}
				System.out.println("swith문 종료 됨");
				// c1.print();
			} else if(n==7)
			{
				break;
			}
		}
	}
}
























