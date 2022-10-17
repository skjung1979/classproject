package chapter12.second;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTransferTest3 {

	public static void main(String[] args) {
		
		// 파일 복사
		// 특정 파일의 데이터를 읽어서 다른 위취에 쓰기를 하는 것!!!
		
		// 읽어올 파일(원본)
		InputStream in = null;
		// 쓸 파일(복사본)
		OutputStream out = null;
		// 보조 스트림(필터 스트림) : 기본 스트림에 보조적인 역할을 하는 스트림
		// 보조 스트림을 이용하기 위해서는 기본스트림이 반드시 먼저 생성되어야 한다.
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
				
		try {
			// 대용량 파일을 복사한다
			in = new FileInputStream("c:\\test\\jdk-17_windows-x64_bin.exe"); // 기본 스트림
			bin = new BufferedInputStream(in); // 버터 스트림 생성자 매개변수에 기본스트림 변수를 넣는다.
			
			out = new FileOutputStream("c:\\test\\jdk-17_windows-x64_bin(복사본2).exe"); // 기본 스트림
			bout = new BufferedOutputStream(out); // 버터 스트림 생성자 매개변수에 기본스트림 변수를 넣는다.
			
			System.out.println("복사가 시작되었습니다.");
			
			while (true) {
				
				int data = bin.read();
				
				if (data == -1) {
					break;
				}
				
				bout.write(data);
				
			}
			
			System.out.println("복사 완료!");
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
		
	}
}
