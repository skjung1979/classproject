package chapter12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableTest {

	public static void main(String[] args) {

		String msg = "안녕하세요.123456";
		
		ObjectOutputStream outputStream = null;
		
		try {
			// 저장할때도 순서대로 넣고(wirteObject()) 
			// 출력할때도 SerializableTest2.java파일에서 순서대로 출력을 해야 한다.
			outputStream = new ObjectOutputStream(new FileOutputStream("instanceData.ser"));
			
			outputStream.writeObject(msg); // 입력1
			
			Person p = new Person("손흥민", 20); // 입력2
			
			outputStream.writeObject(p); // 입력3
			
			ArrayList<Person> list = new ArrayList<>();
			list.add(new Person("손흥민1", 20));
			list.add(new Person("손흥민2", 30));
			list.add(new Person("손흥민3", 40));
			list.add(new Person("손흥민4", 50));
			list.add(new Person("손흥민5", 60));
			
			outputStream.writeObject(list);
			
			System.out.println("저장 되었습니다.");
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
