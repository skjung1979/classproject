package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest1 {

	public static void main(String[] args) {

		// 파일 읽기 : InputStream 필요 => FileInputStream
		FileInputStream in = null;
		
		try {
			in = new FileInputStream("C:\\test\\testfile1.txt");
			
			int data = in.read();
			
			System.out.println(data);
			
			System.out.println((char)data); // 65를 형변환
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			if (in != null) { // in이 null일수 있으므로 이 조건 문장에 예외 처리를 한다.
				try { // 클로저에도 예외 처리한다.
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
