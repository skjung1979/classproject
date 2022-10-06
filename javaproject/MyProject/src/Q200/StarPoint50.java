package Q200;

public class StarPoint50 {

	public static void main(String[] args) {

		printButterfly(5);
		System.out.println("----------------------");
		printDiamond(5);

	}
	
	public static void printStarDec(int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int k=1; k<2*(n-i);k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void printStarInc(int n) {
		
		for(int i=n-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int k=1;k<2*(n-i);k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void printButterfly(int n) {
		printStarDec(n);
		printStarInc(n);
	}
	
	public static void printDiamond(int n) {
		printStarInc(n);
		printStarDec(n);
	}

}
