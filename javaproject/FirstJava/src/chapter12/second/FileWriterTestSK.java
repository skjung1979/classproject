package chapter12.second;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterTestSK {

	public static void main(String[] args) {

		String str = "MegaCoffee";
		char ch = 'A';
		char[] charArr = {'B','C','D'};
		
		Writer writer = null;
		
		try {
			writer = new FileWriter("c:\\test\\text1.txt");
			
			writer.write(str);
			
			System.out.println("파일에 텍스트 문자열 쓰기 완료!");
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			
			if (writer != null) {
				try {
					writer.close(); // 클로즈를 꼭 해줘야 write()도 실행된다!!!
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		

	}

}
