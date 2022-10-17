package chapter12.second;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest1 {

	public static void main(String[] args) {

		// 파일 읽기: InputStream -> FileInputStream	
		FileInputStream in = null;
		
		try {
			
			in = new FileInputStream("c:\\test\\testfile2.txt");
			
			int data = in.read();
			System.out.println(data);
			System.out.println((char)data);
			
		} catch (FileNotFoundException e) {
			System.out.println("지정된 경로에 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			// null인데 close처리하면 또 에러나므로!
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
