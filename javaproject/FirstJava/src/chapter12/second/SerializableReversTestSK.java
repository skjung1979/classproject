package chapter12.second;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerializableReversTestSK {

	public static void main(String[] args) {

		// 읽기
		// InputStream을 이용하여 읽어들이는 것이 역질렬화이다!!!
		
		ObjectInputStream is = null;
		
		try {
			
			is = new ObjectInputStream(new FileInputStream("instanceData.ser"));
		
			String str = (String) is.readObject();
			SerializablePerson sp = (SerializablePerson) is.readObject();
						
			System.out.println(str);
			
			sp.tell();
			
			ArrayList<SerializablePerson> list = (ArrayList<SerializablePerson>) is.readObject();
			
			for (SerializablePerson p : list) {
				p.tell();
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			e.getMessage();
		}

	}

}
