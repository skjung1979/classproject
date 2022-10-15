package chapter11.second;

import java.util.HashSet;
import java.util.Iterator;

// HashSet은 중복 저장되지 않으며, 출력할때는 Iterator while을 통해 출력한다.
// 여기는 참조형 변수를 타입 파라미터롤 정의한 경우

public class HashSetTest2 {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		
		// 저장
		set.add("손흥민");
		set.add("황희찬");
		set.add("이강인");
		set.add("박지성");
		set.add("안정환");
		set.add("손흥민"); // 중복데이터, 저장되지 않음
		
		System.out.println("set의 저장된 요소의 개수: " + set.size());
		
		Iterator<String> itr = set.iterator();
		
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("----------------");
		
		set2.add(7);
		set2.add(10);
		set2.add(14);
		set2.add(10);
		set2.add(40);
		set2.add(70);
		
		System.out.println("set2의 저장된 요소의 개수: " + set2.size());
		
		Iterator<Integer> it = set2.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
