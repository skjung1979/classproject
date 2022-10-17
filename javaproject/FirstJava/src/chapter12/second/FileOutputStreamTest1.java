package chapter12.second;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest1 {

	public static void main(String[] args) {

		// 파일에 쓰기 위해서는 OutputStream이 필요하며 파생 FileOutputStream을 생성한다.
		
		// 상위 타입으로 선언하고, 생성할 때 FileOutputStream으로 해도 된다.
		OutputStream outputStream = null;
		
		try {
			
			// 생성자에 자원의 경로 지정하고 스트림 인스턴스 생성
			outputStream = new FileOutputStream("C:\\test\\testfileㅃㅃㅂ.txt");
			outputStream.write(65);
			
			// outputStream.close(); 이것은 finally로 빼야한다. 예외가 발생하면 실행되지 않으므로!!
			
			System.out.println("파일에 데이터 쓰기 성공!");
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 경로에 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("출력 오류: 데이터 문제");
			e.printStackTrace();
		} finally {
			
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
