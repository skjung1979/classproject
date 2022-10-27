package hio.domain;

public class HioMember {

	private int memberNo; /* 회원번호 */
	private String memberName; /* 회원명 */
	private String memberAddress; /* 회원주소 */
	private String memberPhone; /* 회원전화번호 */
	private String memberId; /* 회원ID */
	private String memberPwd; /* 회원PWD */
	private int memberGrade; /* 회원등급(관리자0,회원1) */
	private int reservNo; /* 예약번호 */
	private String reservDate; /* 예약일자 */
	private int reservTime; /* 예약시간 */
	private int hallNo; /* 홀번호 */	
	private String hallResvYN; /* 예약가능여부 */
	private int hallsTime; /* 예약가능 시작시간 */
	private int halleTime; /* 예약가능 끝시간 */
	
	public HioMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 생성자 - HioMemberDeleteDao -> selectToDelete()에서 사용
	public HioMember(int memberNo, String memberName, String memberAddress, String memberPhone, String memberId,
			String memberPwd, int memberGrade) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
		this.memberPhone = memberPhone;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberGrade = memberGrade;
	}
	
	// 생성자 - HioUpdateController -> memberUpdate() 구절에 사용
	public HioMember(int reservNo, int reservTime, int hallNo) {
		this.reservNo = reservNo;
		this.reservTime = reservTime;
		this.hallNo = hallNo;
		
		
		
	}

	//생성자 - HioAllReservationDao -> 예약 정보 출력에 사용
	public HioMember(String memberName, int reservNo, String reservDate, int reservTime, int hallNo) {
		this.memberName = memberName;
		this.reservNo = reservNo;
		this.reservDate = reservDate;
		this.reservTime = reservTime;
		this.hallNo = hallNo;
	}

	
	
	public HioMember(int reservNo, String reservDate, int reservTime, int hallNo) {
		super();
		this.reservNo = reservNo;
		this.reservDate = reservDate;
		this.reservTime = reservTime;
		this.hallNo = hallNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddres) {
		this.memberAddress = memberAddres;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public int getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}
	public int getReservNo() {
		return reservNo;
	}
	public void setReservNo(int reservNo) {
		this.reservNo = reservNo;
	}
	public String getReservDate() {
		return reservDate;
	}
	public void setReservDate(String reservDate) {
		this.reservDate = reservDate;
	}
	public int getReservTime() {
		return reservTime;
	}
	public void setReservTime(int reservTime) {
		this.reservTime = reservTime;
	}
	public int getHallNo() {
		return hallNo;
	}
	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}
	public String getHallResvYN() {
		return hallResvYN;
	}
	public void setHallResvYN(String hallResvYN) {
		this.hallResvYN = hallResvYN;
	}
	public int getHallsTime() {
		return hallsTime;
	}
	public void setHallsTime(int hallsTime) {
		this.hallsTime = hallsTime;
	}
	
	public int getHalleTime() {
		return halleTime;
	}

	public void setHalleTime(int halleTime) {
		this.halleTime = halleTime;
	}
	
	

	
}
