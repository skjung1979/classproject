package chapter12.second;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableTest2 {

	public static void main(String[] args) {
		
		// 읽기 -> InputStream이용!!! 이것이 역직렬화다!!!
		
		ObjectInputStream inputStream = null;
		
		try {
			
			// 여러개 읽기(역직렬화) 할 경우 저장된 순서에 맞도록
			inputStream = new ObjectInputStream(new FileInputStream("instanceData.ser"));
		
			String str = (String) inputStream.readObject(); // object가 상위이므로 형변화해서 String타입에 넣는다.
			
			Person p = (Person) inputStream.readObject();
			
			System.out.println(str);
			
			p.tell();
			
			ArrayList<Person> list = (ArrayList<Person>) inputStream.readObject();
			
			for (Person person : list) {
				person.tell();
			}		
			
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		

	}

}
