package chapter11.second;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {

		// String 타입의 객체 저장을 위한 ArrayList 객체 생성
		ArrayList<String> list = new ArrayList<>();
		//List<String> list1 = new ArrayList<>(); // 가능
		//List<String> list2 = new ArrayList(); // 가능
		
		// 요소 저장
		list.add("손흥민");
		list.add("박지성");
		list.add(new String("이강인"));
		
		// 요소의 개수
		System.out.println("저장된 요소의 개수: " + list.size());
		System.out.println("------------------------");
		// 요소 참조
		System.out.println(list.get(0));
		System.out.println("------------------------");
		// 일괄 참조
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("------------------------");
		printAll(list);
		
		System.out.println("------------------------");
		
		// 특정위체에 요소 추가
		list.add(1,"안정환");
		
		printAll(list);
		
		System.out.println("------------------------");
		
		// 1번지 요소 삭제
		list.remove(1);
		printAll(list);
		
	}
	
	static void printAll(List<String> list) {
		System.out.println("전체 데이터 출력========");
		for(String name: list) {
			
			System.out.println(name);
		}
		
//		for (int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
	}
}
