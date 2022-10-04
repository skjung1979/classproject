package chapter11;

import java.util.HashSet;

public class SmartPhoneSetTestSK {

	public static void main(String[] args) {

		// HashSet에서는 중복 저장을 하지 않는다.
		// hasCode 참조 -> equals메소드로 비교
		
		HashSet<SmartPhoneSK> set = new HashSet<>();
		
		set.add(new SmartPhoneSK("test1","010-0000-0000"));
		set.add(new SmartPhoneSK("test2","010-3333-3333"));
		set.add(new SmartPhoneSK("test3","010-0000-0000"));
		set.add(new SmartPhoneSK("test4","010-0000-0000"));
		set.add(new SmartPhoneSK("test5","010-1111-1111"));
		set.add(new SmartPhoneSK("test6","010-3333-3333"));

		System.out.println("요소의 개수: " + set.size());
		
		for(SmartPhoneSK sp : set) {
			System.out.println(sp);
		}
		
	}

}
