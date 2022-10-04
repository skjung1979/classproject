package DoItJava;

import java.time.LocalDate;
import java.util.Scanner;

public class YMD {
	
	int y;
	int m;
	int d;
	
	// 생성자
	public YMD(int y, int m, int d) {
		super();
		this.y = y;
		this.m = m;
		this.d = d;
	}
	
	// 각 월의 일수
	static int[][] mdays = {
			{31,28,31,30,31,30,31,31,30,31,30,31}, // 평년
			{31,29,31,30,31,30,31,31,30,31,30,31}, // 윤년
	};
	
	// year년은 윤년인가? 윤년이면 1반환 평년이면 0반환
	static int isLeap(int year) {
		return (year%4 == 0 && year %100 != 0 || year %400 == 0)?1:0;
	}
	
	// n일 후의 날짜 반환
	YMD after(int n){
		YMD temp = new YMD(this.y, this.m, this.d);
		if(n<0) {
			return before(-n);
		}
		temp.d += n;
		
		while(temp.d>mdays[isLeap(temp.y)][temp.m-1]) {
			temp.d -= mdays[isLeap(temp.y)][temp.m-1];
			if(++temp.m>12) {
				temp.y++;
				temp.m = 1;
			}
		}
		return temp;
	}
	
	YMD before(int n) {
		YMD temp = new YMD(this.y, this.m, this.d);
		if(n<0) {
			return after(-n);
		}
		temp.d -= n;
		while(temp.d<1) {
			if(--temp.m<1) {
				temp.y--;
				temp.m = 12;
			}
			temp.d += mdays[isLeap(temp.y)][temp.m-1];
		}
		return temp;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("날짜를 입력하세요.\n");
		System.out.print("년: ");
		int y = stdIn.nextInt();
		System.out.print("월: ");
		int m = stdIn.nextInt();
		System.out.print("일: ");
		int d = stdIn.nextInt();
		YMD date = new YMD(y, m, d);
		
		System.out.println("며칠 전/후의 날짜를 구할까요?: ");
		int n = stdIn.nextInt();
		
		YMD d1 = date.after(n);
		System.out.printf("%d일 후의 날짜는 %d년%d월%d일 입니다.\n", n, d1.y, d1.m, d1.d);
		
		YMD d2 = date.before(n);
		System.out.printf("%d일 전의 날짜는 %d년%d월%d일 입니다.\n", n, d2.y, d2.m, d2.d);
	}	
}
























