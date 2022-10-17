package chapter12.second;

import java.io.FileReader;
import java.io.Reader;

public class FileReaderTestSK3 {

	public static void main(String[] args) {
		
		char[] buf = new char[10];
		int readCnt = 0;
		
		Reader reader = null;
		
		try {
			
			reader = new FileReader("");
			
			while (true) {
				
				readCnt = reader.read(buf);
				
				if (readCnt == -1) {
					break;
				}
				System.out.println(buf);
			}
		}

	}

}
