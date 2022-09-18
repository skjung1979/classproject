package DoItJava;

public class IntArray {

	public static void main(String[] args) {
		// 구성 요소의 자료형이 int형인 배열(구성 요소수는 5 / new에 의해 본체를 생성)
		
		// int[] a = new int[5]; // 배열의 선언
		
		int[] a = {1,2,3,4,5}; // 배열 초기화에 의해 생성
		
		for(int i=0; i<a.length;i++)
		{
			
			System.out.println("a["+i+"] = "+a[i]);
		}

	}

}
