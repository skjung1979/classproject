package chapter11;

import java.util.HashSet;
import java.util.TreeSet;

public class SmartPhoneTreeSetTest {

	public static void main(String[] args) {
		
		TreeSet<SmartPhone> set = new TreeSet<>();
		
		set.add(new SmartPhone("JAVA","010-0000-0000"));
		set.add(new SmartPhone("KANE","010-3333-3333"));
		set.add(new SmartPhone("HWANG","010-0300-0000"));
		set.add(new SmartPhone("SON","010-0040-0000"));
		set.add(new SmartPhone("LEE","010-1111-0000"));
		set.add(new SmartPhone("JORDAN","010-3343-3333"));
		
		System.out.println("요소의 개수: " + set.size());
		
		for(SmartPhone sp : set) {
			System.out.println(sp);
		}

	}

}
