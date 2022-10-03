package DoItJava;

import java.util.Scanner;

public class CardConv {
	
	static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		}while(x != 0);
		
		for(int i=0; i<digits/2; i++) {
			char t = d[i];
			d[i] = d[digits - i - 1];
			d[digits - i - 1] = t;
		}
		return digits;
	}
	
	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);
		int no; // 변환하는 정수, 입력 받기
		int cd; // 기수
		int dno; // 변환 후의 자릿수
		int retry;
		char[] cno = new char[32]; // 변환 후 각 자리의 숫자를 넣어 두는 문자 배열

		System.out.println("10진수를 기수 변환합니다.");
		do {
			do {
				System.out.print("변환하는 음이 아닌 정수: ");
				no = stdIn.nextInt();
			} while (no < 0);

			do {
				System.out.print("어떤 진수로 변환할까요?: ");
				cd = stdIn.nextInt();
			} while (cd < 2 || cd > 36);

			dno = cardConv(no, cd, cno);

			System.out.println(cd + "진수로 ");
			for (int i = 0; i < dno; i++) {
				System.out.print(cno[i]);
			}
			System.out.println("입니다.");

			System.out.println("다시 한 번 할까요?(1.예/0.아니요): ");
			retry = stdIn.nextInt();
		} while (retry == 1);

	}

}
