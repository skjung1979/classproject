package chapter11.second;

import java.util.HashSet;

public class SmartPhoneSetTest {

	public static void main(String[] args) {
		
		HashSet<SmartPhone> set = new HashSet<>();
		
		set.add(new SmartPhone("정성균1", "010-0000-0000"));
		set.add(new SmartPhone("정성균2", "010-1111-1111"));
		set.add(new SmartPhone("정성균3", "010-2222-2222"));
		set.add(new SmartPhone("정성균4", "010-1111-1111"));
		set.add(new SmartPhone("정성균5", "010-3333-3333"));
		set.add(new SmartPhone("정성균6", "010-4444-4444"));
		set.add(new SmartPhone("정성균7", "010-0000-0000"));
		
		System.out.println("요소의 개수: " + set.size());
		
		for(SmartPhone sp : set) {
			System.out.println(sp);
		}
		
	}
}
