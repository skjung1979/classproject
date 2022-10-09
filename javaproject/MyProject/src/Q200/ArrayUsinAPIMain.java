package Q200;

import java.util.Arrays;

public class ArrayUsinAPIMain {

	public static void main(String[] args) {

		int[] a = {5,4,7,1,9,12,0,3,2,6};
		int[] b = new int[a.length];
		int[] c = {5,4,7,1,9,12,0,3,2,6};
		int[] d = null;
		
		// made by user
		ArrayNotUsingAPI.arraycopy(a, b);
		System.out.println(ArrayNotUsingAPI.equals(a, b));
		ArrayNotUsingAPI.fill(b, -6);
		ArrayNotUsingAPI.sort(a);
		ArrayNotUsingAPI.prints(a); // 배열 a 출력
		
		// API
		System.arraycopy(a,0,b,0,a.length);
		d = (int[])c.clone();
		System.out.println(Arrays.equals(d, c));
		Arrays.fill(a, -5);
		Arrays.sort(c);
		ArrayNotUsingAPI.prints(c);

	}

}
