package Q200;

public class VariableArguments {

	public static void main(String[] args) {

		print(3,4,5,6,7);
		
		int[] aa = {5,4,7,1,9,12,0,3,2,6};
		print(aa);
		
		int a=4;
		print(a);
		
		String[] sNames = {"사철나무","소나무","은행나무","벗나무"};
		print(sNames);
		print("동백");
		
		Flower fl = Flower.장미;
		print(fl);
		print(Flower.values());
		
		String s = "Welcon to the Java Programming";
		print(s.split(""));
	}
	
	public static void print(int... p) {
		for(int en : p) {
			System.out.printf("[%d]",en);
		}
		System.out.printf("%n");
	}
	
	public static void print(String... p) {
		for(String en : p) {
			System.out.printf("[%s]",en);
		}
		System.out.printf("%n");
	}
	
	public static void print(Flower... p) {
		for(Flower en : p) {
			System.out.printf("[%s]",en);
		}
		System.out.printf("%n");
	}

}
