package chapter11;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTestSK2 {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<>();
		
		// 저장
		set.add("손흥민");
		set.add("황희찬");
		set.add("김민재");
		set.add("황의조");
		set.add("황희찬");
		
		System.out.println("저장된 요소의 수: " + set.size()); // 중복값은 저장 안 되었음
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
	}

}
