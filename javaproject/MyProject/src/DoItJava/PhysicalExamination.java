package DoItJava;

import java.util.Scanner;

import Q200.CastingRangeMain;

public class PhysicalExamination {
	
	static final int VMAX = 21; // 시력분포(0.0 ~ 0.1 단위로 21개
	
	// 내부 클래스 nested inner class
	static class PhyscData{
		String name;
		int height;
		double vision;
		
		public PhyscData(String name, int height, double vision) {
			super();
			this.name = name;
			this.height = height;
			this.vision = vision;
		}				
	}
	
	// 키의 평균값을 구함
	static double aveHeight(PhyscData[] dat) {
		double sum = 0;
		
		for(int i=0; i<dat.length; i++) {
			sum += dat[i].height;
		}
		return sum / dat.length;
	}
	
	// 시력 분포를 구함
	static void distVision(PhyscData[] dat, int[] dist) {
		int i = 0;
		dist[i] = 0;
		
		for(i=0; i<dat.length; i++) {
			if(dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0) {
				dist[(int)(dat[i].vision*10)]++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		PhyscData[] x = {
			new PhyscData("홍길동", 170, 1.3),
			new PhyscData("김남길", 190, 0.2),
			new PhyscData("김아중", 158, 1.0),
			new PhyscData("박민영", 160, 1.8),
			new PhyscData("김종국", 180, 1.5),
			new PhyscData("김종민", 185, 0.5),
			new PhyscData("김준호", 175, 2.5),
			new PhyscData("김지민", 159, 1.8),
			new PhyscData("탁재훈", 177, 0.1),
			new PhyscData("이상민", 163, 0.5),
			new PhyscData("최진혁", 173, 0.7),
		};
		int[] vdist = new int[VMAX];
		
		System.out.println("* 신체검사 리스트 *");
		System.out.println("이름\t키\t시력");
		System.out.println("==============");
		for(int i=0;i<x.length;i++) {
			System.out.printf("%-8s%3d%5.1f\n",x[i].name, x[i].height, x[i].vision);
		}
		System.out.printf("\n평균 키: %5.1fcm\n", aveHeight(x));
		
		distVision(x, vdist);
		
		System.out.println("\n시력 분포");
		for(int i=0; i<VMAX; i++) {
			// System.out.printf("%3.1f~: %2d명\n", i/10.0, vdist[i]);
			System.out.printf("%3.1f~: ", i/10.0);
			for(int j=0; j<vdist[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}




















