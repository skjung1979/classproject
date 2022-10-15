package chapter11.second;

import java.util.HashSet;

public class SmartPhoneSetTest2 {

	public static void main(String[] args) {

		HashSet<SmartPhone2> set = new HashSet<>();
		
		set.add(new SmartPhone2("정1","010-0000-0000"));
		set.add(new SmartPhone2("정2","010-1111-0000"));
		set.add(new SmartPhone2("정3","010-2222-0000"));
		set.add(new SmartPhone2("정4","010-3333-0000"));
		set.add(new SmartPhone2("정5","010-2222-0000"));
		set.add(new SmartPhone2("정6","010-0000-0000"));

		System.out.println("요소의 개수: " + set.size());
		
		for (SmartPhone2 sp : set) {
			System.out.println(sp);
		}
		
	}

}
