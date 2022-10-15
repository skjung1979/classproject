package chapter11.second;

import java.util.HashSet;
import java.util.Iterator;

// HashSet은 중복 저장되지 않으며, 출력할때는 Iterator while을 통해 출력한다.

public class HashSetTest2 {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<>();
		
		// 저장
		set.add("손흥민");
		set.add("황희찬");
		set.add("이강인");
		set.add("박지성");
		set.add("안정환");
		set.add("손흥민"); // 중복데이터, 저장되지 않음
		
		System.out.println("저장된 요소의 개수: " + set.size());
		
		Iterator<String> itr = set.iterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
