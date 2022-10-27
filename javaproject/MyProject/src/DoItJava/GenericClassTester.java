package DoItJava;

public class GenericClassTester {
	
	// 제네릭 클래스의 매개변수를 T라고 작성함
	static class GenericClass<T>{
		
		private T xyz;
		
		GenericClass(T t){
			this.xyz = t;
		}
		
		T getXyz() {
			return xyz;
		}	
	}
	
	public static void main(String[] args) {
		
		//다음과 같이 인스턴스를 생성할 때 매개변수에 String을 넘길 수도 있고, Integer로 넘길수도 있다!!!
		GenericClass<String> s = new GenericClass<String>("ABC");
		GenericClass<Integer> n = new GenericClass<Integer>(15);
		
		System.out.println(s.getXyz());
		System.out.println(n.getXyz());
		
	}
	

}
