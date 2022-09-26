package chapter08.test;

import chapter08.NewClass;

public class PhoneImpl extends NewClass implements Phone {

	@Override
	public void print() {
		System.out.println("print메소드를 구현했습니다.");

	}

}
