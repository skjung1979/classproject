package chapter11;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTestSK {

	public static void main(String[] args) {


		HashSet<String> set = new HashSet<>();
		
		// 저장
		set.add("손흥민");
		set.add("케인");
		set.add("황희찬");
		set.add("손흥민");
		set.add("황희찬");
		
		System.out.println("저장된 요소의 개수: " + set.size());
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		

	}

}
