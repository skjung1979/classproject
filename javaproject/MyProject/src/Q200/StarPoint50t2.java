package Q200;

public class StarPoint50t2 {

	public static void main(String[] args) {

		printStarDec(5);
		printStarInc(5);

	}
	
	// 별 출력 - 감소하는
	public static void printStarDec(int n) {
		
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<i; j++) {
				System.out.print("-");
			}
			for(int k=1; k<2*(n-i);k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	public static void printStarInc(int n) {
		
		for(int i=n-1; i>0 ; i--) {
			for(int j=0; j<i-1; j++) {
				System.out.print("-");
			}
			for(int k=1; k<2*(n-i)+2; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
