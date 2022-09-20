package MyProject_t;

public class MemberMain_t {

	public static void main(String[] args) {

		Member_t m1 = new Member_t("Son", "010-1111-1111", "축구", 1, "son@gmail.com", 20000101, "런던");

		m1.showMemberInfo();
		
		Member_t m2 = new Member_t("Son", "010-2222-0000", "육상", 4, "sonson@gmail.com");

		m2.showMemberInfo();
		
	}

}
