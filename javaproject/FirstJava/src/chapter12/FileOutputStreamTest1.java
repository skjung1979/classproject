package chapter12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest1 {

	public static void main(String[] args) {

		// 파알에 쓰기 위해서는: OutputStream 필요 -> FileOutputStream
		
		FileOutputStream outputStream = null;
		
		try {
			// 생성자에 파일의 경로 지정하고 스트림 인스턴스 생성 => 경로에 기입한 파일명으로 파일이 생성된다.
			outputStream = new FileOutputStream("C:\\test\\testfile1.txt"); // 경로는 역슬래스 두번
			outputStream.write(65); // 쓰기 => A로 텍스트에 들어간다.
			outputStream.close();
			// => finally을 써서 꼭 예외 처리해야함. FileInputStreamTest1.java파일 참고!!!
			System.out.println("파일에 데이터 쓰기 성공!!");
			
		} catch (FileNotFoundException e) { // 인스턴스 생성 라인에 대한 예외 처리
			System.out.println("해당 경로에 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) { // .write(65)에 대한 예외 처리
			System.out.println("출력 오류!");
			e.printStackTrace();
		}
	}
}
