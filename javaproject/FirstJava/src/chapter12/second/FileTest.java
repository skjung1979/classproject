package chapter12.second;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {

		// File 클래스: 경로를 다루는 클래스
		// 파일과 폴더를 다루는 기능을 사용한다.
		
		File dir1 = new File("c:\\test");
		
		System.out.println("존재 여부: " + dir1.exists());
		System.out.println("폴더 인지 여부: " + dir1.isDirectory());
		System.out.println("파일 여부 확인: " + dir1.isFile());
		
		File dir2 = new File("c:\\test\\backup2");
		
		// 폴더가 존재하지 않으면 새로운 폴더를 생성하는 것
		if (!dir2.exists()) {
			System.out.println("폴더가 존재하지 않습니다. 새로운 폴더를 생성합니다.");
			dir2.mkdir();
			System.out.println("폴더가 생성되었습니다.");
		} else {
			System.out.println("폴더가 존재합니다.");
		}
		
		// 파일 확인
		File file1 = new File(dir2, "test.txt"); // 부모 디렉토리가 들어갈수 있다.
		System.out.println(file1 + "파일 존재 유무: " + file1.exists());
		
		System.out.println();
		
		System.out.println("c:\\test 폴더의 파일 리스트 =====");
		File[] list = dir1.listFiles(); // dir1에서 선언한 폴더의 리스트를 list배열에 넣는다.
		
		for (int i=0; i<list.length; i++) {
			
			if (list[i].isDirectory()) {
				System.out.println("[DIR] " + list[i].getName());
			} else if (list[i].isFile()) {
				System.out.println("[FILE] " + list[i].getName());
			}	
		}
		
		File delFile = new File(dir1, "jdk-17_windows-x64_bin(복사본2).exe");
		System.out.println();
		System.out.println("testfileㅃㅃㅂ.txt 파일 존재 여부: " + delFile.exists());
		
		// 삭제
		if (delFile.exists()) {
			delFile.delete();
			System.out.println("파일이 삭제되었습니다.");
		}
		System.out.println();
		System.out.println("jdk-17_windows-x64_bin(복사본2).exe 파일 존재 여부: " + delFile.exists());
	
		// 파일 이동: backup2으로 데이터 이동
		System.out.println();
		System.out.println("test 폴더에 있는 모든 파일을 backpu2폴더로 이동");
		
		list = dir1.listFiles(); // dir1변수에서 생성한 경로의 디렉토리의 리스트를 받는다.
		
		for (int i=0; i<list.length; i++) {
			// 파일만 이동
			if (list[i].isFile()) {
				// 옮겨야할 경로
				File newFile = new File(dir2, list[i].getName());
				
				// 이동
				list[i].renameTo(newFile);
				System.out.println("+ " + list[i].getName() + "파일이 이동했습니다.");
			}
		}
		System.out.println("test폴더 내부의 모든 파일이 test/backup2 폴더로 이동했습니다.");
		
		System.out.println("c:\\test\\backup2 폴더의 파일 리스트 =====");
		
		File[] newList = dir2.listFiles();
		
		for (int i=0; i<newList.length; i++) {
			
			if (newList[i].isDirectory()) {
				System.out.println("[DIR] " + newList[i].getName());
			} else if (newList[i].isFile()) {
				System.out.println("[FILE] " + newList[i].getName());
			}
		}
	}
}















