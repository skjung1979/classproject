package Q200;

public class PrimeMath {

	// 생성자
	public PrimeMath() {
	}

	// 두 수를 받아서 나누어 떨어지는지 확인
	public boolean isMod(int a, int b) {

		boolean isP = false; // 기본은 나누어 떨어지지 않는다.

		if (b != 0 && a/b == 0) {
			isP = true; // a가 b로 나누어 떨어진다.
		}
		return isP;
	}
	
	// 솟수인지 확인하는 메서드
	public boolean isPri(int a) {
		boolean isP = true;
		
		int b = (int)Math.sqrt(a);
		
		for (int i=2; i<b; i++) {
			if (isMod(a,i)) {	// 두 수가 약수 관계이면 솟수가 아니다.
				isP = false;
				break;
			}
			else isP = true;
		}
		
		return isP;
	}
	
	// 약수의 개수를 구하는 메서드
	// 약수는 1과 자신을 포함한다. 큰 수를 작은 수로 나누어, 나누어 떨어지면 약수 관계가 성립힌다.
	// 나누어 떨어지는 수가 몇 개인지 파악한다.
	public int divisors(int a) {
		int count =1;
		for (int j=2; j<=a; j++) {
			if (isMod(a,j)) {
				count++;
			}
		}
		return count;
	}
	
	// 약수를 구하는 메서드
	// 임의의 한 수를 입력하여 그 수의 모든 약수를 1차원 배열로 리턴한다.
	public int[] commonDividors(int a) {
		int[] b = null;
		int count = 1;
		int num = 1;
		if (a > 1) {
			count = divisors(a);	// 약수 개수 구하는 메서드 호출
			b = new int[count];	// 약수의 개수만큼 배열 선언
			
			b[0] = 1;	// 1은 모든 수의 약수이므로 인덱스가 0인 배열 b에 대입한다.
						// 나머지 약수를 모두 배열에 대입한다. 자신도 약수이므로 배열에 대입된다.
			for (int j=2; j<=a; j++) {
				if (isMod(a,j)) {
					b[num++] = j;
				}
			}
		} else if (a == 1) {	// 1에 대한 약수를 구할때 1의 약수는 1 하나뿐이므로,
								// 크기가 1인 배열을 정의하고 b[0]에 1을 대입한다.
			b = new int[1];
			b[0] = 1;
		}
		return b;
	}
	
	// 출력을 편하게 하는 메서드
	// 약수를 대입한 1차원 배열을 출력하는 메서드이다. 약수의 개수를 앞에 출력하고, []안에 모든 약수를 출력한다.
	public void printPrime(int[] array) {
		int count = array.length;
		System.out.print(count + "개 : [");
		for (int i=0; i<count-1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[count-1]);
		System.out.println(" ]");
	}

}



