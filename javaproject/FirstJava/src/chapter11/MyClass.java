package chapter11;

public class MyClass<T> {

	T val;
	
	T getVal(){ // get으로 메소드 이름을 정한다면 return이 기본적으로 따라옴을 생각해야함.
		return val;
	}
	
	void setVal(T val) {
		this.val = val;
	}
	
	public static void main(String[] args) {
		
		// 제네릭 클래스는 인스턴스 생성시에 타입을 결정한다. 클래스블럭에서가 아니고,, 생성시!!!
		MyClass<String> myClass = new MyClass<String>();
		String str = myClass.getVal();
		
		myClass.setVal("KING");
		System.out.println(myClass.getVal());
		
	}
	
}
