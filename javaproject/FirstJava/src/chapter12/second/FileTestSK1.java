package chapter12.second;

import java.io.File;

public class FileTestSK1 {

	public static void main(String[] args) {
		
		// File클래스: 경로를 다루는 클래스
		// 파일과 폴더를 다루는 기능을 사용한다.
		
		// 생성할 인스턴스가 디렉도리인지 파일인지 변수로 구분하여 생성하는 것이 좋다.
		// ex) dir1, file1 등...
		
		File dir1 = new File("c:\\test"); // 폴더 경로로 인스턴스 선언 및 생성
		
		System.out.println("존재 여부: " + dir1.exists());
		System.out.println("폴더인지 여부: " + dir1.isDirectory());
		System.out.println("파일인지 여부: " + dir1.isFile());
		
		File dir2 = new File("c:\\test\\backup3");
		
		// 폴더가 존재하지 않으면 새로운 폴더를 생성하기
		
		if (!dir2.exists()) {
			System.out.println(dir2.getName()+"폴더가 존재하지 않아 새폴더를 생성합니다.");
			dir2.mkdir(); // 폴더 생성
			System.out.println("폴더가 생성되었습니다.");
		} else {
			System.out.println(dir2.getAbsolutePath());
			System.out.println(dir2.getName()+"폴더가 존재합니다.");
		}
		
		// 파일 확인
		// 위에서 생성한 폴더 인스턴스를 기준으로 파일 확인
		
		// dir2 파일에 test.txt파일명으로 인스턴스 생성(실제 파일 유무는 상관없다.)
		File file1 = new File(dir2, "test.txt");
		System.out.println(file1 + "파일 존재 유무: " + file1.exists());
		
		System.out.println();
		
		System.out.println(file1.getParent() + " 폴더의 파일 리스트====");
		
		//dir1에서 선언한 폴더의 리스트를 list배열에 넣는다.
		File[] list = dir1.listFiles();
		
		// list를 반복문 돌려 출력한다.
		for (int i=0; i<list.length; i++) {
			
			if (list[i].isDirectory()) {
				System.out.println("[DIR] " + list[i].getName());
			} else if (list[i].isFile()) {
				System.out.println("[FILE] " + list[i].getName());
			}
		}
		
		// 파일 존재 여부 확인 후 삭제
		File delFile = new File(dir1, "jdk-17_windows-x64_bin(복사본).exe");
		System.out.println();
		System.out.println(delFile.getName() + " 파일 존재 유무: " + delFile.exists());
		
		// 파일 삭제
		if (delFile.exists()) {
			delFile.delete();
			System.out.println("파일이 삭제되었습니다.");
		}
		System.out.println(delFile.getName() + " 파일 존재 유무: " + delFile.exists());
		
		// 파일 이동: backup2로 파일들 이동
		System.out.println("test 폴더의 모든 파일을 backup3폴더로 이동");
		
		list = dir1.listFiles(); // dir1변수에서 생성한 경로의 폴더 리스트를 받는다.
		
		File newFile = null;
		
		for (int i=0; i<list.length; i++) {
			//파일만 이동
			if (list[i].isFile()) {
				// 옮겨야할 경로
				newFile = new File(dir2, list[i].getName());
				
				// 이동
				list[i].renameTo(newFile);
				System.out.println("+ " + list[i].getName() + " 파일이 이동했습니다.");
			}
		}
		System.out.println(dir1.getName() + " 폴더의 모든 파일이 " + newFile.getParent() + " 폴더로 이동했습니다.");
		
		System.out.println(newFile.getParent() + " 폴더의 파일 리스트 =====");
		
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





















