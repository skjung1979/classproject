package ver02;

public class SmartPhoneMainSK {

	public static void main(String[] args) {
		
		//SmartPhoneSK sp = new SmartPhoneSK(10); 이렇게 할 필요 없다. 이미 생성해 놨으니 호출해서 사용

		SmartPhoneSK sp = SmartPhoneSK.getInstance();
		
		while(true)
		{

			System.out.println("==========================");
			System.out.println("# 전화번호부:");
			System.out.println("@원하시는 메뉴 번호를 입력하세요@");
			System.out.println("1. 연락처 저장");
			System.out.println("2. 연락처 검색");
			System.out.println("3. 연락처 수정");
			System.out.println("4. 연락처 삭제");
			System.out.println("5. 연락처 전체 출력");
			System.out.println("6. 프로그램 종료");
			System.out.println("==========================");
			System.out.println("==========================");
			
			int select = Integer.parseInt(sp.sc.nextLine());
			
			switch(select)
			{
			case 1:
				sp.insertContact();
				break;
			case 2:
				sp.searchInfoPrint();
				break;
			case 3:
				sp.editContact();
				break;
			case 4:
				sp.deleteContact();
				break;
			case 5:
				sp.printAllData();
				break;
			case 6:
				System.out.println("bye~ bye~");
				return;
			}
		}	
	}
}
