package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest2 {

	public static void main(String[] args) {

		// 파일 읽기 : InputStream 필요 => FileInputStream
		FileInputStream in = null;
		
		try {
			in = new FileInputStream("C:\\test\\testfile2.txt");
			
			while(true) { // while 블록 안에 탈출 조건을 넣어준다.
				int data = in.read();
				if(data == -1) { // data가 -1(더이상 파일의 문자가 없으면 반환되는 값)이면 while 탈출(break)하자
					break;
				}
				System.out.print((char)data); // 문자를 10진수로 표하므로 이렇게 형변환해줘야 한다.			
			}
			System.out.println();
			System.out.println("데이터 읽기 성공!!!");	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
