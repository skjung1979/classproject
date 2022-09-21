package chapter06;

public class ArrayTest6 {

	public static void main(String[] args) {

	// 참조형 변수를 다루는 배열:객체를 저장하는
		String[] names = new String[3];
		
		for(String name : names)
		{
			System.out.println(name); // 초기값이 없으므로 String의 기본초기값 null이 나옴
		}
		
		names[0] = "박지성";
		names[1] = "손흥민";
		names[2] = "이강인";
		
		for(String name : names)
		{
			System.out.println(name); // 대입한 축구 선수 이름 나열됨
		}
		
		System.out.println(names[0].length());
		System.out.println(names[1].equals("손흥민"));
		
	}
}
