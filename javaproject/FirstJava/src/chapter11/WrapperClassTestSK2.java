package chapter11;

import java.util.ArrayList;

public class WrapperClassTestSK2 {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		printAll(list);
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("Son");
		list2.add("king");
		
		printAll(list2);
		
	}

	static <E> void printAll(ArrayList<E> list) {
		for(E obj : list) {
			System.out.println(obj);
		}
	}
	
}
