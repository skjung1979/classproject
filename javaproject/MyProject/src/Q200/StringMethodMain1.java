package Q200;

public class StringMethodMain1 {

	public static void main(String[] args) {
		// String immutable
		String st = "hello";
		System.out.println("st + st.hashCode() => " + (st+st.hashCode()));
		
		st.replace('h', 'H');
		
		st = st.replace('h', 'H');
		System.out.println("st + st.hashCode() => " + (st+st.hashCode()));
		
		// String의 위치 메소드 인덱스는 0부터
		String test1 = "Hello my nick name is totoro.\n";
		test1 += "I'm 29 years old.\n";
		test1 += "I'm a good man.";
		
		System.out.println("이글의 길이 : " + test1.length());
		System.out.println("첫번째 .위치 : " + test1.indexOf('.')); // -1이면 없다는 것!
		System.out.println("마지막 .위치 : " + test1.lastIndexOf('.'));
		System.out.println("첫번째 years위치 : " + test1.indexOf("years"));
		
		// 위치에 있는 한글자씩 부르기
		System.out.println("for문을 이용해서 test1을 한글자씩 불려온다.");
		for(int i=0; i<test1.length(); i++) {
			System.out.print(test1.charAt(i));
		}
		System.out.println();
		System.out.println();
		// 원하는 문자열 배열
		String[] a = test1.split("\n"); // \n로 구분하여 배열 변수 a에 넣는다.
		System.out.println(a.length);
		System.out.println(a[0]);
		
		// 문자열 나누기 index는 0부터 시작한다.
		String b = test1.substring(4,8);
		String c = test1.substring(0,5);
		String bb = test1.substring(4);
		
		System.out.println(b);
		System.out.println(c);
		System.out.println(bb);

	}

}
