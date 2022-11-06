package Q200;

public class TetrisMain {

	public static void main(String[] args) {
		
		Tetris tetris = new Tetris(TetrisUtil.TETRISA); // 변하지 않는 배열이라 상수로 선언해서 유틸이라고 명하여 담아놨다.
		
		tetris.printTetris(); // TETRISA 출력
		
		tetris.turnLeft(); // TETRISA를 왼쪽으로 회전
		tetris.printTetris(); // 왼쪽으로 회전한 결과 출력
		
		tetris.turnLeft(); // 또 왼쪽으로 회전
		tetris.printTetris(); // 다시 출력
		
		tetris.turnLeft(); // 또 왼쪽으로 회전
		tetris.printTetris(); // 다시 출력
		
		tetris.turnRight(); // TETRISA를 오른쪽으로 회전
		tetris.printTetris(); // 오른쪽으로 회전한 결과 출력
		
		tetris.turnRight(); // 또 오늘쪽으로 회전
		tetris.printTetris(); // 다시 출력
		
		tetris.turnRight(); // 또 오늘쪽으로 회전
		tetris.printTetris(); // 다시 출력
		
	}
	
}
