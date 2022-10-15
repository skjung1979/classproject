package chapter11.second;

import chapter11.second.MyInterface2;

public class MyInterfaceImpl2<T1, T2> implements MyInterface2<T1, T2> {

	public static void main(String[] args) {

		MyInterfaceImpl2<String, Integer> myClass = new MyInterfaceImpl2<>();
		
		System.out.println(myClass.method1("안녕 제네릭"));
		System.out.println(myClass.method2(11111));
	}

	@Override
	public T1 method1(T1 t) {
		return t;
	}

	@Override
	public T2 method2(T2 t) {
		return t;
	}

	@Override
	public T1 method1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T2 method2() {
		// TODO Auto-generated method stub
		return null;
	}
}
