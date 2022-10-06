package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableTest2 {

	public static void main(String[] args) {

		ObjectInputStream inputStream = null;
		
		try {
			// serializableTest.java파일에서 저장할때도 순서대로 넣고(wirteObject()) 
			// 아 파일에서 출력할때도 출력을 해야 한다.
			inputStream = new ObjectInputStream(new FileInputStream("instanceData.ser"));
			
			String str = (String)inputStream.readObject();
			
			Person p = (Person)inputStream.readObject();
			
			System.out.println(str); // 출력1
			
			p.tell(); // 출력2
			
			ArrayList<Person> list = (ArrayList<Person>)inputStream.readObject();
			
			for(Person person : list) { // 출력3
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
