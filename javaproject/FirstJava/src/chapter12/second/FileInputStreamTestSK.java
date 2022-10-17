package chapter12.second;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTestSK {

	public static void main(String[] args) {

		// 파일 일기: InputStream -> FileInputStream
		InputStream in = null;

		try {
			
			in = new FileInputStream("c:\\test\\testfile3.txt");
			int data = in.read();
			
			System.out.println(data);
			System.out.println((char)data);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
}
