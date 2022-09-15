package chapter03;

import java.util.Scanner;
	
public class Exam03_01_CM_KDW {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
				
		double m_dPrimal, m_dSecond;
		float m_fRadius;
		
		while(true)
		{
			System.out.println("원하는 기능을 선택하세요");
		
			System.out.println("1. 덧셈 2. 뺄셈 3. 곱셈 4. 나눗셈(몫 반환), 5. 나눗셈(나머지 반환), 6. 원의 넓이 계산, 7. 원의 둘레 계산, etc. 종료");
			switch(scan.nextInt())
			{
			case 1:
				System.out.println("더할 첫번째 숫자를 입력하세요");
				m_dPrimal = scan.nextDouble();
			
				System.out.println("더할 두번째 숫자를 입력하세요");
				m_dSecond = scan.nextDouble();
			
				System.out.println("결과값 : " + Add(m_dPrimal,m_dSecond));
			
				break;
			case 2:
				System.out.println("뺄 첫번째 숫자를 입력하세요");
				m_dPrimal = scan.nextDouble();
			
				System.out.println("뺄 두번째 숫자를 입력하세요");
				m_dSecond = scan.nextDouble();
			
				System.out.println("결과값 : " + Sub(m_dPrimal,m_dSecond));
			
				break;
			case 3:
				System.out.println("곱할 첫번째 숫자를 입력하세요");
				m_dPrimal = scan.nextDouble();
			
				System.out.println("곱할 두번째 숫자를 입력하세요");
				m_dSecond = scan.nextDouble();
			
				System.out.println("결과값 : " + Mul(m_dPrimal,m_dSecond));
			
				break;
			case 4:
				System.out.println("나눌 첫번째 숫자를 입력하세요");
				m_dPrimal = scan.nextDouble();
			
				System.out.println("나눌 두번째 숫자를 입력하세요");
				m_dSecond = scan.nextDouble();
			
				System.out.println("결과값 : " + Div(m_dPrimal,m_dSecond));
			
				break;
			case 5:
				System.out.println("나눌 첫번째 숫자를 입력하세요");
				m_dPrimal = scan.nextDouble();
			
				System.out.println("나눌 두번째 숫자를 입력하세요");
				m_dSecond = scan.nextDouble();
			
				System.out.println("결과값 : " + Rem(m_dPrimal,m_dSecond));
			
				break;
			case 6:
				System.out.println("원의 반지름을 입력하세요");
				m_fRadius = scan.nextFloat();
			
				System.out.println("결과값 : " + CalRadian(m_fRadius));
			
				break;
			case 7:
				System.out.println("원의 반지름을 입력하세요");
				m_fRadius = scan.nextFloat();
			
				System.out.println("결과값 : " + CalRound(m_fRadius));
			
				break;

			default:
				System.out.println("계산기 종료");
				return;
			}
		}
	}
	
	static double Add(double primary, double secondary)
	{
		return primary + secondary;
	}
	
	static double Sub(double primary, double secondary)
	{
		return primary - secondary;
	}
	
	static double Mul(double primary, double secondary)
	{
		return primary * secondary;
	}
	
	static double Div(double primary, double secondary)
	{
		return primary / secondary;
	}
	
	static double Rem(double primary, double secondary)
	{
		return primary % secondary;
	}
	
	static double CalRadian(float Radius)
	{
		return Radius * Radius * Math.PI;
	}
	
	static double CalRound(float Radius)
	{
		return Radius * 2 * Math.PI;
	}
	
}
