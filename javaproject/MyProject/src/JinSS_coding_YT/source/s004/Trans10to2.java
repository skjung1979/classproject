package JinSS_coding_YT.source.s004;

import java.util.Scanner;

// 10진수를 2진수로 변환하시오
// 19
// 정답: 10011

public class Trans10to2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("10진수를 2진수로 변환합니다.");
        System.out.println("10진수를 입력해주세요. >> ");
        int inputNum = sc.nextInt();

        int arr[] = new int[100];

//        for (int i=0; i<10; i++){
//            arr[i] = inputNum % 2;
//            inputNum /= 2;
//            if(inputNum < 0){
//                break;
//            }
//        }
//
//        for (int i=9; i>0; i--){
//            System.out.print(arr[i]);
//        }
        
        int i = 0;
        int mok = inputNum;
        
        while (mok > 0) {
        	arr[i] = mok % 2;
        	mok /= 2;
        	i++;
        }
        
        i--;
        for (; i>=0; i--) {
        	System.out.print(arr[i]);
        }
        


    }
    
}
