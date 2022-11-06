package Q200;

public class Tetris {
	
	private int [][] tetris = TetrisUtil.TETRISA;

	public Tetris(int[][] tetris) {
		super();
		this.tetris = tetris;
	}
	
	public Tetris() {
		
	}
	
	public void setTetris(int[][] is) {
		tetris = is;
	}
	
	public void turnRight() {
		
		int temp = tetris[0][0];	// 오른쪽으로 회전할 경우의 회전포인트
		tetris[0][0] = tetris[3][0];
		tetris[3][0] = tetris[3][3];
		tetris[3][3] = tetris[0][3];
		tetris[0][3] = temp;
		
		temp = tetris[0][1];		
		tetris[0][1] = tetris[2][0];
		tetris[2][0] = tetris[3][2];
		tetris[3][2] = tetris[1][3];
		tetris[1][3] = temp;
		
		temp = tetris[0][2];	
		tetris[0][2] = tetris[1][0];
		tetris[1][0] = tetris[3][1];
		tetris[3][1] = tetris[2][3];
		tetris[2][3] = temp;
		
		temp = tetris[1][1];
		tetris[1][1] = tetris[2][1];
		tetris[2][1] = tetris[2][2];
		tetris[2][2] = tetris[1][2];
		tetris[1][2] = temp;
	}
	
	public void turnLeft() {	// 왼쪽으로 회전할 경우의 회전포인트
		int temp = tetris[3][0];
		tetris[3][0] = tetris[0][0];
		tetris[0][0] = tetris[0][3];
		tetris[0][3] = tetris[3][3];
		tetris[3][3] = temp;
		
		temp = tetris[1][0];
		tetris[1][0] = tetris[0][2];
		tetris[0][2] = tetris[2][3];
		tetris[2][3] = tetris[3][1];
		tetris[3][1] = temp;
		
		temp = tetris[2][0];
		tetris[2][0] = tetris[0][1];
		tetris[0][1] = tetris[1][3];
		tetris[1][3] = tetris[3][2];
		tetris[3][2] = temp;
		
		temp = tetris[1][1];
		tetris[1][1] = tetris[1][2];
		tetris[1][2] = tetris[2][2];
		tetris[2][2] = tetris[2][1];
		tetris[2][1] = temp;
	}
	
	public void printTetris() {
		int m = tetris.length; // 행의 개수
		int n = tetris[0].length; // 열의 개수
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(tetris[i][j] + "");
			}
			System.out.println();
		}
		System.out.println("============================");
		
		
	}
	
	

}

















