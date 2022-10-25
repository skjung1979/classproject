package DoItJava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhyExamSearch {
	
	// 신체 검사 데이터를 정의
	static class PhyscData{
		
		private String name; // 이름
		private int height; // 키
		private double vision; // 시력
		
		// 생성자
		public PhyscData(String name, int height, double vision) {
			super();
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		
		// 문자열로 만들어 반환하는 메소드
		public String toString() {
			return name + " " + height + " " + vision;
		}
		
		// 키의 오름차순으로 정렬하기 위한 comparator
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhyscData>{
			
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0; 
				
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		PhyscData[] x = {new PhyscData("강민하", 162, 0.3),
						new PhyscData("이수연", 168, 0.4),
						new PhyscData("황지안", 162, 0.3),
						new PhyscData("유서범", 165, 0.2),
						new PhyscData("김찬우", 168, 1.3),
						new PhyscData("장경오", 165, 2.2),
						new PhyscData("박준서", 175, 1.5)};
		
		for (int i=0; i<x.length; i++) {
			System.out.println(x[i].name);
		}
			
		while (true) {
			System.out.print("키와 시력이 궁금한 사람을 입력 해 주세요. (9. 그만하기)>> ");
			String name = sc.nextLine();
			
			if (name.equals("9")) break;

			int a = 0;
			for (int i=0; i<x.length; i++) {
				if (name.equals(x[i].name)) {
					System.out.println(x[i].name + "의 키: " + x[i].height + " / 시력: " + x[i].vision);
					break;
				} else {
					
					a = 1;
					
				}
			
			}
			if (a == 1) 	System.out.println("리스트의 이름 중 입력해주세요.");
			continue;
		}
	
		
		
		//int idx = Arrays.binarySearch(x, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);
		
//		if (idx < 0) {
//			System.out.println("그 값의 요소가 없습니다.");
//		} else {
//			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
//			System.out.println("찾은 데이터: " + x[idx]);
//		}	
	}
}



















