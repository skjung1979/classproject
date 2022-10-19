package chapter12.second;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SerializableTestSK1 {

	public static void main(String[] args) {

		// OutputStream을 이용하여 쓰기하는 것이 직렬화!!!
		
		String msg = "안녕하세요. 정성균 입니다.";
		
		ObjectOutputStream os = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream("instanceData.ser"));

			os.writeObject(msg);
			
			SerializablePerson sp = new SerializablePerson("정성균", 18);
			
			os.writeObject(sp);
			
			ArrayList<SerializablePerson> list = new ArrayList<>();
			
			list.add(new SerializablePerson("손흥민", 24));
			list.add(new SerializablePerson("박세웅", 23));
			list.add(new SerializablePerson("황희찬", 22));
			list.add(new SerializablePerson("이강인", 21));
			list.add(new SerializablePerson("이대호", 27));
			list.add(new SerializablePerson("전준우", 28));
			list.add(new SerializablePerson("한동희", 29));
			
			os.writeObject(list);
			
			System.out.println("저장 되었습니다.");	
			
			os.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
