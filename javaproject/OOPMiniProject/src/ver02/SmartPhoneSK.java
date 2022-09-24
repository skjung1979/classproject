package ver02;

import java.util.Scanner;

public class SmartPhoneSK {
	// 메소드를 모안 놓은 기능 클래스이다. 속성X, 메소드로만 정의
	// 싱글톤 패턴:
	// 1. private 생성자
	// 2. 클래스 블록 내부에서 static private 표기하여 인스턴스 생성
	// 3. 내부에서 생성한 참조값을반환하는 메소드. 메소드 이름  앞에 static public 표기
	
	private ContactSK[] contacts; // 배열 변수 선언
								  // 생성자에서 초기화 해도 된다.
	
	private int numOfContact;	// 입력된 정보의 개수를 받는 변수 선언, 생성은 생성자에서
	Scanner sc;	// 스캐너 선언, 생성은 생성자에서
	
	
	
	// 싱글톤 요건: 생성자(초기화메소드) 선언시 private 표기
	private SmartPhoneSK(int size)
	{
		contacts = new ContactSK[size]; // size를 받아서 contacts배열 변수 초기화 한다.
		numOfContact = 0;	// 입력 개수 변수 초기화
		sc = new Scanner(System.in); // 스캐너 초기화
	}
	
	// 싱글톤 요건: 인스턴스 생성 시 private, static 표기
	private static SmartPhoneSK sp = new SmartPhoneSK(10);
	
	// 싱글톤 요건: 반환 메소드에는 public static 표기
	public static SmartPhoneSK getInstance()
	{
		if(sp == null)
		{
			sp = new SmartPhoneSK(10);
		}
		return sp;
	}
	
	// 이름 검색 후 데이터 수정
	void editContact()
	{
		// 검색어 입력 받기
		System.out.println("데이터 수정이 진행 됩니다.");
		System.out.print("수정하고자 하는 이름을 입력해주세요. >> ");
		String name = sc.nextLine();
		
		int searchIndex = -1; // 아무것도 입력된 것이 없는 상태
		
		// 데이터 찾기
		for(int i=0; i<numOfContact; i++)
		{
			if(contacts[i].getName().equals(name))
			{
				searchIndex = i;
				break;
			}
		}
		if(searchIndex<0)
		{
			System.out.println("찾으시는 데이터가 존재하지 않습니다.");
			return;
		}
		//searchIndex가 0이상이면 데이터가 존재한다는 것
		ContactSK contact = contacts[searchIndex];
		
		System.out.println("-----데이터 수정을 진행합니다.-----");
		System.out.println("변경하고자하는 이름을 입력해주세요. (현재값: "+contact.getName()+")\n"
				+ "변경하지 않으려면 엔터키를 누르세요 >>>");
		String newName = sc.nextLine();
		if(newName != null && newName.trim().length()>0)
		{
			contact.setName(newName);
		}
		
		System.out.println("변경하고자하는 전화번호를 입력해주세요. (현재값: "+contact.getPhoneNumber()+"\n"
				+ "변경하지 않으려면 엔터키를 누르세요. >>>");
		String newPhoneNumber = sc.nextLine();
		if(newPhoneNumber != null && newPhoneNumber.trim().length()>0)
		{
			contact.setPhoneNumber(newPhoneNumber);
		}
		
		System.out.println("변경하고자하는 이메일을 입력해주세요. (현재값: "+contact.getEmail()+"\n"
				+ "변경하지 않으려면 엔터키를 누르세요. >>>");
		String newEmail = sc.nextLine();
		if(newEmail != null && newEmail.trim().length()>0)
		{
			contact.setEmail(newEmail);
		}
		
		System.out.println("변경하고자하는 주소를 입력해주세요. (현재값: "+contact.getAddress()+"\n"
				+ "변경하지 않으려면 엔터키를 누르세요. >>>");
		String newAddress = sc.nextLine();
		if(newAddress != null && newAddress.trim().length()>0)
		{
			contact.setAddress(newAddress);
		}
		
		System.out.println("변경하고자하는 생일을 입력해주세요. (현재값: "+contact.getBirthday()+"\n"
				+ "변경하지 않으려면 엔터키를 누르세요. >>>");
		String newBirthday = sc.nextLine();
		if(newBirthday != null && newBirthday.trim().length()>0)
		{
			contact.setBirthday(newBirthday);
		}
		System.out.println("정보 수정 완료");
		
	}
	
	// 삭제 (이름 검색)
	void deleteContact()
	{
		// 검색어 받기
		System.out.println("데이터 삭제가 진행됩니다.-----");
		System.out.println("삭제하고자 하는 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		// 삭제 원하는 index 찾기
		int searchIndex = -1; // 현재 검색 결과는 없다는 것!
		
		// 데이터 찾기
		for(int i=0; i<numOfContact;i++)
		{
			if(contacts[i].getName().equals(name))
			{
				searchIndex = i;
				break;
			}
		}
		
		// 검색한 index값으로 분기
		if(searchIndex<0)
		{
			System.out.println("삭제하고자하는 이름의 데이터가 존재하지 않습니다.");
		}else
		{
			for(int i=searchIndex; i<numOfContact-1; i++)
			{
				contacts[i] = contacts[i+1];
			}
			numOfContact--;
			System.out.println("데이터가 삭제되었습니다.");
		}	
	}
	
	// 검색 후 결과 출력 (이름 검색)
	void searchInfoPrint()
	{
		String name = null;
		System.out.println("검색을 시작합니다.");
		System.out.print("검색할 이름을 입력하세요. >>>");
		name = sc.nextLine();
		
		ContactSK contact = null;
		
		for(int i=0; i<numOfContact; i++)
		{
			if(contacts[i].getName().equals(name))
			{
				contact = contacts[i];
				break; // 반복문 벗어남.
			}
		}
		
		// 검색 결과 출력
		System.out.println("검색 결과 ==============");
		if(contact == null)
		{
			System.out.println("입력한 이름 " + name + "의 검색 정보가 없습니다.");
		}else
		{
			contact.printInfo();
		}	
	}
	
	// 전체 입력 데이터의 출력
	void printAllData()
	{
		System.out.println("전체 데이터를 출력합니다==========");
		if(numOfContact==0)
		{
			System.out.println("입력된 정보가 없습니다.");
			return; // 메소드 호출한 곳으로 이동
		}
		for (int i=0; i<numOfContact; i++)
		{
			contacts[i].printInfo();
		}
	}
	
	// 정보 입력
	void insertContact()
	{
		if(numOfContact==contacts.length)
		{
			System.out.println("최대 저장 개수는 "+ contacts.length + "개 입니다.");
			return;
		}
		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;
		
		// 1. 데이터 입력 받기
		System.out.println("입력을 시작합니다.");
		System.out.print("이름 >");
		name = sc.nextLine();

		System.out.print("전화번호 >");
		phoneNumber = sc.nextLine();

		System.out.print("이메일 >");
		email = sc.nextLine();

		System.out.print("주소 >");
		address = sc.nextLine();

		System.out.print("생일 >");
		birthday = sc.nextLine();

		System.out.print("그룹 >");
		group = sc.nextLine();
		
		// 2. 인스턴스 생성
		ContactSK contact = new ContactSK(name, phoneNumber, email, address, birthday, group);
		
		// 3. 배열에 저장하고 입력 순번을 증가 시킨
		contacts[numOfContact++] = contact; // 인덱스값0에 넣고 numOfContact를 증가 시킨다.
		
	}
}



















