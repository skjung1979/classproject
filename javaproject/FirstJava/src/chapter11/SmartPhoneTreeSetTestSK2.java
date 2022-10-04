package chapter11;

import java.util.HashSet;
import java.util.TreeSet;

public class SmartPhoneTreeSetTestSK2 {

	public static void main(String[] args) {

		// HashSet에서는 중복 저장을 하지 않는다.
		// hasCode 참조 -> equals메소드로 비교
		
		TreeSet<SmartPhoneSK> set = new TreeSet<>();
		
		set.add(new SmartPhoneSK("JAVA","010-0000-0000"));
		set.add(new SmartPhoneSK("SON","010-3333-3333"));
		set.add(new SmartPhoneSK("KANE","010-0000-0000"));
		set.add(new SmartPhoneSK("Fall","010-0000-0000"));
		set.add(new SmartPhoneSK("Winter","010-1111-1111"));
		set.add(new SmartPhoneSK("James","010-3333-3333"));

		System.out.println("요소의 개수: " + set.size());
		
		for(SmartPhoneSK sp : set) {
			System.out.println(sp);
		}
		
	}

}
