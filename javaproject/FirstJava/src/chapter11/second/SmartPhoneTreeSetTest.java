package chapter11.second;

import java.util.HashSet;
import java.util.TreeSet;

public class SmartPhoneTreeSetTest {

	public static void main(String[] args) {
		
		TreeSet<SmartPhone> set = new TreeSet<>();
		
		set.add(new SmartPhone("JAVA", "010-0200-0000"));
		set.add(new SmartPhone("SON", "010-1111-1111"));
		set.add(new SmartPhone("APPLE", "010-2222-2222"));
		set.add(new SmartPhone("KING", "010-1111-1111"));
		set.add(new SmartPhone("BIT", "010-3323-3333"));
		set.add(new SmartPhone("QUEEN", "010-4444-4444"));
		set.add(new SmartPhone("ZORO", "010-0100-0000"));
		
		System.out.println("요소의 개수: " + set.size());
		
		for(SmartPhone sp : set) {
			System.out.println(sp);
		}
		
	}
}
