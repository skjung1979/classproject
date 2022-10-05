package chapter11;

import java.util.HashSet;

public class SmartPhoneSetTestSK2 {

	public static void main(String[] args) {

		HashSet<SmartPhoneSK2> set = new HashSet<>();
		
		set.add(new SmartPhoneSK2("test1", "010-0000-0000"));
		set.add(new SmartPhoneSK2("test2", "010-3333-3333"));
		set.add(new SmartPhoneSK2("test3", "010-0000-0000"));
		set.add(new SmartPhoneSK2("test4", "010-0000-0000"));
		set.add(new SmartPhoneSK2("test5", "010-1111-1111"));
		set.add(new SmartPhoneSK2("test6", "010-3333-3333"));
		
		System.out.println("요소의 개수: " + set.size());

		for(SmartPhoneSK2 sp : set) {
			System.out.println(sp);
		}
		
	}

}
