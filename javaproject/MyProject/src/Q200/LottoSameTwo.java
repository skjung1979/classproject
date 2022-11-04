package Q200;

import java.util.Arrays;

public class LottoSameTwo {
	
	// 한수가 두번씩 고르게 섞인 1차원 배열 만들기

	private int n;
	private int[] ball;
	
	public LottoSameTwo(int n) {
		setSame(n);
	}
	
	public LottoSameTwo() {
		setSame(10);
	}

	public void setSame(int n) {
		this.n = n;
		ball = new int[n];
		Arrays.fill(ball, -1);
	}
	
	public int[] getBall() {
		return ball;
	}
	
	private int isSame(int[] a, int b) {
		int isS = 0;
		for (int i=0; i<a.length; i++) {
			if (a[i] == b) {
				isS++;
			}
		}
		return isS;
	}
	
	// 원하는 수의 배열 만들기
	public void make() {
		int count = 0;
		
		while (true) {
			//Math.rnadom()
			int b = (int)(Math.random()*(n/2));
			if (isSame(ball,b) < 2) {
				ball[count++] = b;
			}
			if (count == n) {
				break;
			}
		}
	}
	
}










