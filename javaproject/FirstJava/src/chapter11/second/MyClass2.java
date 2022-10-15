package chapter11.second;
// 제네릭: 클래스 내부에서 T타입의 변수, T타입 게터, T타입 세터를 선언/정의하고,
//		 메인메소드에서 인스턴스 생성할 때 실제 타입으로 생성하는 것이다.
//		 타입별로 메소드나 변수를 만들 필요가 없다.

public class MyClass2<T> {
	
	T val;
	
	T getVal() {
		return val;
	}
	
	void setVal(T val) {
		this.val = val;
	}
	
	public static void main(String[] args) {
		
		// 제네릭 클래스는 인스턴스 생성시에 타입을 결정한다!!!
		MyClass<String> myClass = new MyClass<>();
		
		String str = myClass.getVal();
		// 이 라인이 "myClass.setVal("안녕")" 뒤로 가면 null이고, 아래로 가면 "안녕"
		
		myClass.setVal("안녕");
		
		System.out.println(myClass.getVal());
		System.out.println(str);
		
	}

}
