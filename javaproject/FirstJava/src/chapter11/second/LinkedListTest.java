package chapter11.second;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(40);
		list.add(50);
		list.add(10);
		list.add(20);
		list.add(30);
		
		
		// Iterator를 이용한 일괄 처리
		Iterator<Integer> it = list.iterator();
		
		System.out.println("=== Iterator로 출력 ===");
		while (it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
		}
		System.out.println("-------------");
		
		
		
		
		WrapperClassTest.printAll(list);
	}
}
