package chapter06;

public class ArrayTest2 {
	
	public static void main(String[] args) {
		
		// 배열 인스턴스 생성과 초기화
		int[] arr1 = {100, 80, 20, 40, 30};
		System.out.println("arr1 요소의 개수: "+ arr1.length); // arr1 요소의 개수 출력
		
		
		for(int i=0; i<arr1.length; i++) // 변식으로 카운팅 변수를 만들어 조건에 넣으면 입력한 개수만큰 반복 시킬 수 있다. ★중요★
		{
			System.out.print(arr1[i]+"\t");
		}
		System.out.println();
		
		int[] arr2 = new int[] {1, 2, 3, 4, 5, 10, 9};
		System.out.println("arr2의 요소의 개수: "+ arr2.length); // arr2의 요소 개수 출력
		
		System.out.println("배열 arr2의 요소 출력");
		for(int i=0; i<arr2.length; i++)
		{
			System.out.println(arr2[i]);
		}
		
		// 역순으로 출력하기 6	5	4	3	2	1
		System.out.println("역순으로 출력");
		for(int i=arr2.length-1; i>=0; i--)
		{
			System.out.println(arr2[i]);
		}
		
	}

}
