package chapter12.second;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {

	public static void main(String[] args) {

		//BufferedWriter out = null;
		
		
		// try() <- 괄호 안에서 객체 선언, 생성하면 자동으로 close()처리가 된다.
		try (BufferedWriter out = new BufferedWriter(new FileWriter("c:\\test\\SmartPhoneContacts1.txt"))) {
			//out = new BufferedWriter(new FileWriter("c:\\test\\SmartPhoneContacts1.txt"));
			
			out.write("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			out.newLine();
			out.write("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			out.newLine();
			out.write("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
			out.newLine();
			out.write("나무위키 참조");
			
			System.out.println("작성 완료!!!!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
