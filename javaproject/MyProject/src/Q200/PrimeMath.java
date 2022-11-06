package Q200;

public class PrimeMath {

	// 생성자
	public PrimeMath() {
	}

	// 두 수를 받아서 나누어 떨어지는지 확인
	public boolean isMod(int a, int b) {

		boolean isP = false; // 기본은 나누어 떨어지지 않는다.

		if (b != 0 && a/b == 0) {
			isP = true; // a가 b로 나누어 떨어진다.
		}
		return isP;
	}

}
