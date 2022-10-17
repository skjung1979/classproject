package chapter12.second;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTestSK {

	public static void main(String[] args) {

		char[] buf = new char[10];
		int readCnt = 0;
		
		Reader reader = null;
		
		try {
			reader = new FileReader("c:\\test\\text1.txt");
			
			while (true) {
				
				readCnt = reader.read(buf);
				
				if (readCnt == -1) {
					break;
				}	
				System.out.println(buf);
			}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
