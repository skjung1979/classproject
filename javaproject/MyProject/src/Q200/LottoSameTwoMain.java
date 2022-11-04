package Q200;

import JinSS_coding_YT.BubbleSort;

public class LottoSameTwoMain {

	public static void main(String[] args) {

		LottoSameTwo lotto = new LottoSameTwo(10);
		
		lotto.make();
		
		for (int i=0; i<lotto.getBall().length; i++) {
		System.out.print(lotto.getBall().toString().charAt(i) + '\t');
		}
		System.out.println();
		
		BubbleSort.print(lotto.getBall());
		
		lotto.setSame(12);
		
		lotto.make();
		
		BubbleSort.print(lotto.getBall());

	}

}
