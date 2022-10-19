package chapter12.second;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableTest {

	public static void main(String[] args) {

		// 쓰기 -> OutputStream이용!!! 이것이 직렬화다!!!
		
		String msg = "안녕하세요123";
		
		ObjectOutputStream outputStream = null;
		
		try {
			// 여러개 쓰기(직렬화) 할 경우 저장된 순서에 맞도록
			// OutputStream은 필터스트림이므로 기본스트림을 괄호에 넣어 생성한다.
			outputStream = new ObjectOutputStream(new FileOutputStream("instanceData.ser"));
		
			// 메인메소드에서 선언한 변수 msg의 데이터를 instanceData.ser에 쓰기
			outputStream.writeObject(msg); // String 문자 타입 저장 / 직렬화 가능한 객체를 넣어준다.
			
			Person p = new Person("손흥민", 20); // Person 타입 변수 2개 저장
			
			// Person클래스의 인스턴스에 생성한 값으로 넣기. 한건
			outputStream.writeObject(p);
			
			// list를 선언, 생성해서 list값을 instanceData.ser에 쓰기
			ArrayList<Person> list = new ArrayList<>(); // 리스트 타입 변수 저장
			
			list.add(new Person("손흥민1", 21));
			list.add(new Person("손흥민2", 22));
			list.add(new Person("손흥민3", 23));
			list.add(new Person("손흥민4", 24));
			list.add(new Person("손흥민5", 25));

			outputStream.writeObject(list);
			
			System.out.println("저장 되었습니다.");	
		
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
