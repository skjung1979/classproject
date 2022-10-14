package chapter11.second;
// 제네릭: 클래스 내부에서 T타입의 변수, T타입 게터, T타입 세터를 선언/정의하고, 메인메소드에서 인스턴스 생성할때 실제 타입을 설정하여 결정할 수 있다.

public class MyClass<T> {

	// T타입 변수
	T val;
	
	// T타입 게터
	T getVal(){
		return val;
	}
	
	// T타입 세터
	void setVal(T val) {
		this.val = val;
	}
	
	
	public static void main(String[] args) {
		
		// 제네릭 클래스는 인스턴스 생성시에 타입을 결정한다. !!!
		MyClass<String> myClass = new MyClass<String>();
		String str = myClass.getVal();
		
		myClass.setVal("안녕");
		System.out.println(myClass.getVal());
		
	}
	
}
