package chapter12.second;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest2 {

	public static void main(String[] args) {

		// 파일에 쓰기 위해서는 OutputStream이 필요하며 파생 FileOutputStream을 생성한다.
		
		// 상위 타임으로 선언하고, 생성할때는 하위 타입으로 한다.
		OutputStream outputStream = null;
		
		try {
			outputStream = new FileOutputStream("c:\\test\\test2.txt");
			outputStream.write(65);
			
			System.out.println("파일에 데이터 쓰기 성공!!!");		
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 경로에 지정한 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("output 오류: 데이터 문제입니다.");
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
