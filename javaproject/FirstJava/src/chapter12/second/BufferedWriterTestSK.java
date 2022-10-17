package chapter12.second;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTestSK {

	public static void main(String[] args) {

		// try() <- 괄호 안에서 객체 선언, 생성하면 자동으로 try구문 빠져나올때 자동으로 close()처리가 된다.
		// BufferedWriter는 필터 스트림이므로, 기본스트림(FileWriter)을 매개변수로 넣어야 한다.
		try (BufferedWriter out = new BufferedWriter(new FileWriter("c:\\test\\SmartPhoneContacts1.txt"))){

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
