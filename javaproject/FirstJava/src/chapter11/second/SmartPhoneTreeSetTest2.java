package chapter11.second;

import java.util.TreeSet;

public class SmartPhoneTreeSetTest2 {

	public static void main(String[] args) {

		TreeSet<SmartPhone2> set = new TreeSet<>();
		
		set.add(new SmartPhone2("JAVA", "010-0100-0000"));
		set.add(new SmartPhone2("ADAM", "010-0200-0000"));
		set.add(new SmartPhone2("BOB", "010-0030-0000"));
		set.add(new SmartPhone2("ZORO", "010-0040-0000"));
		set.add(new SmartPhone2("TIGER", "010-0050-0000"));
		set.add(new SmartPhone2("STEVE", "010-0060-0000"));
		
		System.out.println("요소의 개수: " + set.size());
		
		for (SmartPhone2 sp : set) {
			System.out.println(sp);
		}

	}

}
