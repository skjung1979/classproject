package chapter06;

public class Member
{
	
	private int memberNo;
	private String memberID;
	private String memberName;
	
	// 생성자 자동 생성
	public Member(int memberNo, String memberID, String memberName)
	{
		this.memberNo = memberNo;
		this.memberID = memberID;
		this.memberName = memberName;
	}

	// toString 자동 생성
	@Override
	public String toString()
	{
		// 아래 return의 패턴을 변형하여 사용하라!!!
		return "Member [memberNo=" + memberNo + ", memberID=" + memberID + ", memberName=" + memberName + "]";
	}

	// getter 자동 생성 (getter만 생성: 읽기 전용)	
	public int getMemberNo() {
		return memberNo;
	}

	public String getMemberID() {
		return memberID;
	}

	public String getMemberName() {
		return memberName;
	}
	
	public static void main(String[] args)
	{
		
		// 회원 5명의 정보를 저장할 수 있는 배열 
		// 선언, 생성
		Member[] members = new Member[5];
		
		// 각 배열의 요소에 초기화
		members[0] = new Member(1,"cool","COOL");
		members[1] = new Member(2, "hot", "HOT");
		members[2] = new Member(3, "son", "SON");
		members[3] = new Member(4, "kane", "KANE");
		members[4] = new Member(5, "jeong", "JEONG");
		
		// 배열을 이용해서 각 객체의 값을 참조해서 출력
		for(int i=0; i<members.length;i++)
		{
			System.out.printf("%d번 회원의 아이디는 %s이고, 이름은 %s이다.\n"
					, members[i].getMemberNo()
					, members[i].getMemberID()
					, members[i].getMemberName());
		}
		
		System.out.println("---------------------------------------");
		
		for(Member member : members)
		{
			System.out.println(member); // member.toString() 메소드를 호출한다.
		}
		
	}
}




























