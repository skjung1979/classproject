package Q200;

public class StarPoint50t3 {

	public static void main(String[] args) {

		//printStarDec(5); // 행의 개수이다.
		printStarInc(5);
		
	}
	
	// 별 감소 메소드
	public static void printStarDec(int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("-");
			}
			for(int k=1; k<2*(n-i); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	// 별 증가 메소드
	public static void printStarInc(int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--) {
				System.out.print("-");
			}
			System.out.println();
		}
		
	}
	
}























