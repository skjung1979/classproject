package chapter11.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsTest2 {
	
	public static void main(String[] args) {
		
		List<Integer> lotto = new ArrayList<>();
		
		for (int i=0; i<6; i++) {
			lotto.add(new Random(System.nanoTime()).nextInt(45)+1);
		}
		
		Collections.sort(lotto); // 오름차순 정렬
		printAll(lotto);
		
		System.out.println("최대값: " + Collections.max(lotto));
		System.out.println("최소값: " + Collections.min(lotto));
		
		Collections.reverse(lotto);
		printAll(lotto);
		
		System.out.println("=================");
		
		// 섞기
		Collections.shuffle(lotto);
		printAll(lotto);
		
		// lotto 요소를 지우려면 'Collections.emptyList()'를 lotto변수에 대입한다.
		Collections.emptyList();
		System.out.println("리스트 요소의 개수: " + lotto.size());
		
		System.out.println("=================");
		
		List<Integer> list1 = Collections.emptyList();
		System.out.println("emptyList() 후 리스트1 요소의 개수: " + list1.size());
		
	}
	
	static void printAll(List<Integer> list) {
		for (int n : list) {
			System.out.println(n);
		}
	}
}
