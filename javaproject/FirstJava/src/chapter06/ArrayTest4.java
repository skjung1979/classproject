package chapter06;

public class ArrayTest4 {

	public static void main(String[] args) {
		
		// 2차원 배열: 1차원 배열의 집합이다. (3차원 배열도 1차원 배열의 집합!!!)
		// 선언: int[][] arr
		// 생성: new int[][]
		
		int[][] arr = new int[2][3];
		// arr은 요소개수가 3개인 1차원 배열 2개를 가지는 배열 인스턴스를 가르킨다.
		// 1차원 배열의 사이즈는 3
		System.out.println("2차원 배열의 사이즈: "+ arr.length);
		System.out.println("첫번째 1차원 배열의 사이즈: "+ arr[0].length);
		System.out.println("첫번째 1차원 배열의 사이즈: "+ arr[1].length);
		
		System.out.println();
		
		// 배열 요소에 참조
		arr[0][0] = 11;
		arr[0][1] = 12;
		arr[0][2] = 13;
		arr[1][0] = 21;
		arr[1][1] = 22;
		arr[1][2] = 23;
		
		for(int i=0; i<arr.length; i++) // 조건식에 입력한 배열의 (전체)사이즈는 행의 개수이다.
		{
			for(int j=0; j<arr[i].length; j++) // 조건식에 입력한 i차원 배열의 사이즈는 열의 개수이다.
			{
				System.out.print("arr["+i+"]"+"["+j+"] = "+ arr[i][j]+"\t");
			}
			System.out.println(); // i가 바뀌면 개행
		}
		
		// 2차원 배열의 초기화
		int[][] scores =
			{	// 각각의 1차원 배열은 3개의 요소를 갖는다.
					{11,12,13},
					{21,22,23},
					{31,32,33},
					{41,42,43},
			};
		
		// i = 0 1 2 3
		for(int i=0; i<scores.length; i++)
		{
			for(int j=0; j<scores[i].length; j++)
			{
				System.out.print(scores[i][j]+"\t");
			}
			System.out.println();
		}	
	}
}
