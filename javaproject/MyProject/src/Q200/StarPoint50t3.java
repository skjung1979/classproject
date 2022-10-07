package Q200;

public class StarPoint50t3 {

	public static void main(String[] args) {

		//printStarDec(5); // 행의 개수이다.
		printStarDec1(5);
		printStarDec2(5);
		printStarDec3(5);
		
		printStarInc1(5);
		printStarInc2(5);
		
	}
	
	// 별 감소 메소드 1
	public static void printStarDec1(int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int k=1; k<2*(n-i); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	// 별 감소 메소드 2
	public static void printStarDec2(int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=n-i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	// 별 감소 메소드 3
	public static void printStarDec3(int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int k=n-i; k>0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// 별 증가 메소드 1
	public static void printStarInc1(int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=n-i-1; j>0; j--) {
				System.out.print(" ");
			}
			for(int k=0; k<=i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}	
	}
	
	// 별 증가 메소드 2
	public static void printStarInc2(int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}























