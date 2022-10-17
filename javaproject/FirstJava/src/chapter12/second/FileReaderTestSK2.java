package chapter12.second;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTestSK2 {

	public static void main(String[] args) {

		char[] buf = new char[200];
		int readCnt = 0;
		
		Reader reader = null;
		
		try {
			reader = new FileReader("c:\\test\\SmartPhoneContacts1.txt");
			
			readCnt = reader.read(buf);
			
			System.out.println(buf);
			System.out.println(readCnt);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
