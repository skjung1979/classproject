package chapter11.second;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WrapperClassTest {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(10); // 오토박싱
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		printAll(list);
		
		System.out.println("----------");
		
		ArrayList<String> list2 = new ArrayList<>();
		
		list2.add("SON");
		list2.add("SON");
		list2.add("SON");
		list2.add("SON");
		
		printAll(list2);

	}
	
	// 아래처럼 제네릭으로 해야 무슨 타입의 리스트이든 아래 메소드를 실행할수 있다.
	static <E> void printAll(List<E> list) {
		for (E obj: list) {
			System.out.println(obj);
		}
	}

}
