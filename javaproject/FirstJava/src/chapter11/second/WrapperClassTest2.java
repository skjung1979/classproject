package chapter11.second;

import java.util.ArrayList;
import java.util.List;

public class WrapperClassTest2 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		printAll(list);
		
		System.out.println("-----------------");
		
		ArrayList<String> list2 = new ArrayList<>();
		
		list2.add("son");
		list2.add("son");
		list2.add("son");
		list2.add("son");
		list2.add("son");
		list2.add("son");
		
		printAll(list2);

	}
	
	static <E> void printAll(List<E> list) {
		for (E obj : list) {
			System.out.println(obj);
		}
	}

}
