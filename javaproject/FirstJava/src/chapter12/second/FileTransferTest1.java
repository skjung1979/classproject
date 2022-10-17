package chapter12.second;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTransferTest1 {

	public static void main(String[] args) {
		
		// 파일 복사
		// 특정 파일의 데이터를 읽어서 다른 위취에 쓰기를 하는 것!!!
		
		// 읽어올 파일(원본)
		InputStream in = null;
		// 쓸 파일(복사본)
		OutputStream out = null;
		
		try {
			in = new FileInputStream("c:\\test\\testfile2.txt");
			out = new FileOutputStream("c:\\\\test\\\\testfile2(복사본).txt");
			
			while (true) {
				
				int data = in.read();
				
				if (data == -1) {
					break;
				}
				
				out.write(data); // 읽어 온 데이터를 쓰는 작업
			}
			
			System.out.println("복사 완료!");
						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
