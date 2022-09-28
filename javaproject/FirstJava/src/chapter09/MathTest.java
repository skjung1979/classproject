package chapter09;

public class MathTest {

	public static void main(String[] args) {
		// PI
		System.out.println(Math.PI);
		
		// 난수 생성
		System.out.println(Math.random());
		// 1~45 난수
		int num = (int)(Math.random()*45)+1;	// 1~44
		System.out.println(num);
		
		// 절사
		System.out.println(Math.floor(3.6002));
		
		// 반올림: 0.5이상
		System.out.println(Math.round(3.4002));
		
		// 최대값 or 최소값: 같은 타입의 2개 값을 받아서 큰값(or 작은값)을 추출
		//System.out.println(Math.max(10,  20));
		//System.out.println(Math.min(10, 30));
		
		int num1 = (int)(Math.random()*46)+1;
		int num2 = (int)(Math.random()*46)+1;
		int num3 = (int)(Math.random()*46)+1;
		int num4 = (int)(Math.random()*46)+1;
		int num5 = (int)(Math.random()*46)+1;
		int num6 = (int)(Math.random()*46)+1;
		
		System.out.println(num1 + "\t" + num2 + "\t" + num3 + "\t" + num4 + "\t" + num5 + "\t" + num6);
		

	}

}
