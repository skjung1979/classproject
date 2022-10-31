package Q200;

public class MagicSquare {

	public static void main(String[] args) {

		int width = 3;
		
		int[][] magic = new int[width][width];

		int y = width / 2;
		int x = 0;

		for (int i=0; i<width; i++){

			for (int j=0; j<width; j++){

				if (magic[x][y] == 0){
					
					magic[x][y] = i * width + j + 1; // magig[x][y]값이 0이라면 1이라는 값을 대입하고

				} else { // 아니면 자리를 옮긴다!!!!

					int tempX = x;
					int tempY = y;

					if (x-1 < 0) { // x가 1이하인 경우

						x = width - 1; // x가 2이상인 수가 된다.

					} else { // x가 2이상인 경우

						x = x - 1; // x가 양수가 된다.
					}

					if (y-1 < 0) { // y가 1이하인 경우

						y = width - 1; // y는 2이상인 수가 된다.

					} else {

						y = y - 1; // y는 양수가 된다.

					}
					// => tempX와 temp에는 1이상인 수가 대입된다.

					if (magic[x][y] == 0) {

						magic[x][y] = i * width + j + 1;

					} else {

						x = tempX + 1;
						y = tempY;

						if (magic[x][y] == 0) {

							magic[x][y] = i * width + j +1;

						}
					}
				}
			}
		}
		
		int total1 = 0;
		int total2 = 0;
		int total3 = 0;
		
		for (int i=0; i<width; i++) {

			for (int j=0; j<width; j++) {

				if (i == j) { // 대각선

					total1 += magic[i][j];

				}

				if (i == 0) { // 첫번째 행

					total2 += magic[i][j];

				}

				if (i + j + 1 == width) { // i와 j가 1인 경우 => 정중앙 (1,1)

					total3 += magic[i][j];

				}
				//System.out.print("(" + i + ", " + j + ") = " + magic[i][j]);
				System.out.print("|\t" + magic[i][j] + "\t|\t");

			}
			System.out.println();

		}
		System.out.println("total1 = " + total1);
		System.out.println("total2 = " + total2);
		System.out.println("total3 = " + total3);

	}

}

// (0, 3/2)에 1 (3+0+0+1)로 시작한다. <= i=0이고, j=0일때는 magic(0,1)에 값 1을 넣고 1회 반복문은 끝났다.
// 기본 흐름을 적용하면 (-1, 0)이 되며, x 경계 조건에 의해 (3-1, 0)에 2 (3*0+1+1+)를 대입한다. <= i=1이고, j=1일때는 magin(2,0)값 2를 넣고, 2회 반복문 끝났다.
// 다시 기본 흐름을 적용하여 (2-1, 0-1)이 되는데, y 경계 조건에 따라 (1, 3-1)에 3 (3*0+2+1)을 대입한다.
// 기본 흐름을 적용하면 (1-1, 2-1)이 되나 이미 1이 있으므로 원래 위치(1, 2)에 대해 (1+1, 2)에 4를 대입한다.
