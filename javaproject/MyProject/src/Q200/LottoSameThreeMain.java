package Q200;

import JinSS_coding_YT.BubbleSort;

public class LottoSameThreeMain {

	public static void main(String[] args) {

		LottoSameThree lotto3 = new LottoSameThree(12);
		
		lotto3.make();
		
		BubbleSort.print(lotto3.getBall());
		
		lotto3.setSame(18);
		
		lotto3.make();
		
		BubbleSort.print(lotto3.getBall());

	}

}
