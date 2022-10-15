package chapter11.second;

import java.util.ArrayList;

public class ArrayListTest2 {

	public static void main(String[] args) {

		// ArrayList: 순서대로 저장, 중복 허용
		// String 타입의 객체 저장을 위한 ArrayList 객체 생성
		ArrayList<String> list = new ArrayList<>();
		
		// 요소 저장
		list.add("정성균");
		list.add("박민영");
		list.add("손흥민");
		list.add(new String("황희찬"));
		
		// 요소 개수
		System.out.println("저장된 요소의 개수: " + list.size());
		System.out.println("-------------------------");
		
		// 요소 참조: 요소의 값을 불러온다. 배열의 index와 같은 개념
		System.out.println("0번째 요소 참조: " + list.get(0));
		System.out.println("-------------------------");
		
		// 요소 일괄 참조
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + "번째 요소: " + list.get(i));
		}
		System.out.println("-------------------------");
		System.out.println("메소드에서 데이터 출력");
		printAll(list);
		System.out.println("-------------------------");
		
		// 특정 위치에 요소 추가
		list.add(2, "안정환");
		printAll(list);
		System.out.println("-------------------------");
		
		// 1번지 요소 삭제
		list.remove(1);
		printAll(list);
		

	}
	
	static void printAll(ArrayList<String> list) {
		
		System.out.println("===전체 데이터 출력(메소드호출)===");
		for(String name : list) {
			
			System.out.printf(name+"\t");
		}
		System.out.println();
		
	}

}
