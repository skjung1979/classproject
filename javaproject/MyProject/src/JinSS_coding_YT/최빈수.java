package JinSS_coding_YT;

import java.util.Scanner;

public class 최빈수 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("10의 숫자를 입력해주세요. >>> ");
        
        int[] inputNum = new int[10];

        for (int i=0; i<10; i++){

            inputNum[i] = Integer.parseInt(sc.nextLine());

        }

        int[] mode = new int[10];
        
        for (int i=0; i<10; i++){

            mode[inputNum[i]]++;

        }

        int modeNum = 0;
        int modeCnt = 0;

        for (int i=0; i<10; i++){

            if (modeCnt < mode[i]) {

                modeCnt = mode[i];
                modeNum = i;

            }

        }
        System.out.println("최빈수: " + modeNum);
        System.out.println("최빈수 횟수: " + modeCnt);

    }
    
}
