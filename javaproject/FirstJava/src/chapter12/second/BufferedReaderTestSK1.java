package chapter12.second;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTestSK1 {

	public static void main(String[] args) {

		try (BufferedReader in = new BufferedReader(new FileReader("c:\\test\\SmartPhoneContacts1.txt"))) {
			
			while (true) {
				
				String str = in.readLine(); // 해당 파일을 한줄 단위로 읽어 온다.
				
				if (str == null) {
					break;
				}
				
				System.out.println(str);
			}
			
			System.out.println("프로그램 종료");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
