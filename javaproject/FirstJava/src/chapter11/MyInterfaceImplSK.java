package chapter11;

public class MyInterfaceImplSK<T1, T2> implements MyInterfaceSK<T1, T2> {

	@Override
	public T1 method1(T1 t) {
		// TODO Auto-generated method stub
		return t;
	}

	@Override
	public T2 method2(T2 t) {
		// TODO Auto-generated method stub
		return t;
	}
	
	public static void main(String[] args) {
		// 인스턴스를 생성할때 타입을 지정한다.
		MyInterfaceImplSK<String, Integer> myClass = new MyInterfaceImplSK<>(); 
		
		// 메소드 호출
		System.out.println(myClass.method1("TEN"));
		System.out.println(myClass.method2(10));
	}
	
	

}
