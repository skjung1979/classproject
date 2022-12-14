package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsTest {

	public static void main(String[] args) {

		List<Integer> lottoNumber = new ArrayList<>();

		
		
		for(int i=0; i<6; i++) {
		
			lottoNumber.add(new Random(System.nanoTime()).nextInt(45)+1);
		}
		
		printAll(lottoNumber);
			
		System.out.println("최대값: " + Collections.max(lottoNumber));
		System.out.println("최소값: " + Collections.min(lottoNumber));
		
		System.out.println();
		
		Collections.sort(lottoNumber); // 오름차순 정렬
				
		printAll(lottoNumber);
		
		System.out.println();
		// 역순으로 정렬
		Collections.reverse(lottoNumber); // 역순으로 정력
		printAll(lottoNumber);
		
		System.out.println();
		// 섞기
		Collections.shuffle(lottoNumber);
		printAll(lottoNumber);
		
		System.out.println();
		List<Integer> list1 = Collections.emptyList(); // 비어있는 요소 객체 생성
		System.out.println("리스트 요소의 개수: " + list1.size());
		
		
		
		
		
	}
	
	
	static void printAll(List<Integer> list) {
		for(int n : list) {
			System.out.println(n);
		}
	}
	

}
