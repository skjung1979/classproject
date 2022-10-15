package chapter11.second;

import java.util.LinkedList;

public class LinkedListTest2 {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);

		WrapperClassTest2.printAll(list);
		
	}
}
