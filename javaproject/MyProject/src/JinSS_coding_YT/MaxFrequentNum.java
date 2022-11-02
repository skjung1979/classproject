package JinSS_coding_YT;

import java.util.Scanner;

public class MaxFrequentNum {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("10개의 숫자를 입력해주세요. >> ");

        int[] inputNum = new int[10];

        for (int i=0; i<10; i++){

            inputNum[i] = Integer.parseInt(sc.nextLine());

        }

        int[] mode = new int[10];

        for (int i=0; i<10; i++){

            mode[inputNum[i]] += 1; // inputNum의 값을 인덱스로하는 mode를 1씩 증가시킨다.

        }

        int maxNum = 0; // 최대 빈도 수
        int maxCnt = 0; // 최대 빈도 횟수

        for (int i=0; i<10; i++){

            if (maxCnt < mode[i]){

                maxCnt = mode[i];
            maxNum = i;

            }
        }
        System.out.println("최빈수: " + maxNum);
        System.out.println("최빈수 횟수: " + maxCnt);

    } 
}
