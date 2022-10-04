package chapter11;

import java.util.ArrayList;

public class WrapperClassTestSK {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(10); // 오토박싱
		list.add(30);
		list.add(25);
		list.add(50);
		list.add(70);
		
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
