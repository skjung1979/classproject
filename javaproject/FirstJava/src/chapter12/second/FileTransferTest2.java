package chapter12.second;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTransferTest2 {

	public static void main(String[] args) {
		
		// 파일 복사
		// 특정 파일의 데이터를 읽어서 다른 위취에 쓰기를 하는 것!!!
		
		// 읽어올 파일(원본)
		InputStream in = null;
		// 쓸 파일(복사본)
		OutputStream out = null;
		int copyByte = 0; // 총 복사한 데이터 사이즈
		int bytedataSize = 0;
		byte[] bufData = new byte[1024];
		
		try {
			// 대용량 파일을 복사한다
			in = new FileInputStream("c:\\test\\jdk-17_windows-x64_bin.exe");
			out = new FileOutputStream("c:\\test\\jdk-17_windows-x64_bin(복사본).exe");
			
			
			
			System.out.println("복사가 시작되었습니다.");
			
			while (true) {
				
				int byteDataSize = in.read(bufData);
				
				if (byteDataSize == -1) {
					break;
				}
				
				out.write(bufData, 0, byteDataSize); // 읽어 온 데이터를 쓰는 작업
				copyByte += byteDataSize;
			}
			
			System.out.println("복사 완료!");
			System.out.println("복사한 파일의 size: " + copyByte);
						
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
