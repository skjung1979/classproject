package chapter12.second;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest2 {

	public static void main(String[] args) {

		// 파일 읽기: InputStream -> FileInputStream	
		FileInputStream in = null;
		
		try {
			
			in = new FileInputStream("c:\\test\\testfile3.txt");
			
			// 데이터를 하나씩 읽어 온다. 여러개의 문자의 데이터가 있는 경우 아래 코드를 통해 읽어와야한다.
			while (true) {
				
				int data = in.read(); // 파일으리 데이터를 읽어와서 변수에 담는다.
				
				if (data == -1) { // 반환 데이터가 없으면,
					break; // while문 탈출
				}
				System.out.print((char)data);
				
			}
			System.out.println("데이터 읽기 성공");
			
			
		
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
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
