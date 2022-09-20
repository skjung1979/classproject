package chapter05;

public class LocalVariable {

	void method(int num)
	{	// 매개변수도 지역변수
		
		int lv = 10;	// 매소드 내부에서 선언되는 변수도 지역변수이다.
		
		if(num>10)
		{
			boolean check = true;
		}else
		{
			boolean check = false;
		}
		// int lv = 11; // 선언 불가
		
		for(int i=0; i<10; i++)
		{	// i는 for블록 안에서만 사용 가능한 지역변수이다.
				}
		// System.out.println(i);	// 오류: i는 for블록 안에서만 사용 되므로
		
		while(lv<0)
		{
			int lv2 = 0;
		}
		// System.out.println(lv2);	// 오류: lv2는 블록안에서 선언되었으므로
		// lv2를 사용하려면 while블록 밖에서 'int lv2'로 선언해 준다.
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalVariable lv = new LocalVariable();
		lv.method(0);
		
	}

}
