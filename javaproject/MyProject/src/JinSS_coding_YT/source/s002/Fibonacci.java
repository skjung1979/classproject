package JinSS_coding_YT.source.s002;

import java.util.Scanner;

// 피보나치 수열을 출력해라
// An = An-1 + An-2
// 1 1 2 3 5 8 13 21 34 ...
// >>> 배열, for

public class Fibonacci {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("피보나치 수열을 출력합니다.");
        
        int inputnum = 0;
        while (inputnum < 3){

            System.out.println("원하시는 배열 개수를 입력하세요. >> ");
            inputnum = sc.nextInt();

            if (inputnum < 3){
                System.out.println("3이상의 값을 입력해주세요.");
            } else {
                break;
            }
        }
        
        int arr[] = new int[inputnum];

        arr[0] = 1;
        arr[1] = 1;

        System.out.print(arr[0] + "\t" + arr[1] + "\t");

        for (int i=2; i<inputnum; i++){

            arr[i] = arr[i-1] + arr[i-2];

            System.out.print(arr[i]+"\t");

            if (i % 5 == 0) {
                System.out.println();
            }

        }
        


    }
    
}
