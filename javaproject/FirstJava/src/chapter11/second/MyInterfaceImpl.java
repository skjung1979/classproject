package chapter11.second;

import chapter11.MyInterface;

public class MyInterfaceImpl<T1, T2> implements MyInterface<T1, T2> {

	@Override
	public T1 method1(T1 t) {
		return t;
	}

	@Override
	public T2 method2(T2 t) {
		return t;
	}
	
	public static void main(String[] args) {
		
		MyInterfaceImpl<String, Integer> myClass = new MyInterfaceImpl<>();
		
		System.out.println(myClass.method1("안녕 제네릭 T1"));
		System.out.println(myClass.method2(100));
	}

}
