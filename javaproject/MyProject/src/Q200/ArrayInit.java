package Q200;

public class ArrayInit {

	public static void main(String[] args) {
		
		int[] a = null; // 기본 타입의 배열 선언
		
		a = new int[5]; // 5개의 인덱스로 정의(생성)
		
		a[0] = 2; // 초기화
		a[1] = 3;
		a[2] = 5;
		a[3] = 6;
		a[4] = 7;
		
		int[] b = new int[]{2,3,4,5,6,}; // 선언, 정의(생성), 초기화 한번에
		
		int[] c = {1,2,3,4,5,}; // 더 간단히 선언, 정의, 초기화
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
		
		int[] d = a; // 참조에 의한 대입
		a[4] = 55; // a값을 변동시키면 d의 값은? 변한다. 참조에 의한 변수는 서로 영향을 받는다.
		for(int i=0; i<a.length; i++) {
			System.out.print(d[i]+"\t");
		}
		
		System.out.println();
		
		int[] e = new int[5];
		System.arraycopy(d, 0, e, 0, d.length);
		d[4] = 100; // d의 값을 변동시키면 e의 값은 바뀔까? 영향을 받지 않는다.
		for(int i=0; i<e.length; i++) {
			System.out.print(e[i]+"\t");
		}

	}

}
