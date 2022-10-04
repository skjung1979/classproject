package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CollectionTestSK {

	public static void main(String[] args) {
		
		List<Integer> lottoNumber = new ArrayList<>();

		
		
		int[] nm = new int[6];
		
		for(int i=0; i<nm.length; i++) {
			// lottoNumber.add(new Random(System.nanoTime()).nextInt(45)+1); // 0~9까지

			nm[i] = new Random(System.nanoTime()).nextInt(45)+1;
			lottoNumber.add(nm[i]);
			
			for(int j=0; j<i; j++) {
				if(nm[i] == nm[j]) {
					i--;
					break;
				}
			}
		}
		
		
		Collections.sort(lottoNumber);
		
		System.out.println();
		
		printAll(lottoNumber);
		
		System.out.println();
		
		System.out.println("최대값: " + Collections.max(lottoNumber));
		System.out.println("최소값: " + Collections.min(lottoNumber));
		
		// 역순으로 정렬
		System.out.println("=== 역순 정렬 ===");
		Collections.reverse(lottoNumber);
		printAll(lottoNumber);
		
		// 섞기
		Collections.shuffle(lottoNumber);
		System.out.println("=== 섞기 ===");
		printAll(lottoNumber);
		
		List<Integer> list1 = Collections.emptyList();
		System.out.println("리스트 요소의 개수: " + list1.size());
			

	}

	static void printAll(List<Integer> list) {
		for(int n : list) {
			System.out.println(list.indexOf(n)+ " => "+n);
		}
	}
	
}
