package JinSS_coding_YT.source.s003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 문제 소개
// 가장 많이 출현한 수를 출력하시오.
// 1 2 2 3 1 4 2 2 4 3 5 32
// 정답: 2 (5회)

public class MaxFrequentNumber {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("가장 많이 출현한 수를 출력합니다.");
        System.out.println("몇개의 수를 입력하실 건가요? >> ");
        int cnt = sc.nextInt();

        int arr[] = new int[cnt];

        System.out.println(cnt + "개의 수를 입력해주세요. >> ");
        for (int i=0; i<cnt; i++){

            int input = sc.nextInt();

            arr[input]++;

            

        }

        // for (int i=0; i<10; i++){
        //     System.out.print(arr[i] + "\t");
        // }
    

        // 가장 많이 출현한 수는? -> num
        // 그 수의 횟수는? -> count

        List<Integer> num = new ArrayList<>();
        int MaxCnt = 0;

            
        for (int i=1; i<arr.length; i++){
            
            if (arr[i] > arr[i-1]){

                MaxCnt = arr[i];
            
                // num.add(i);

            } 
        }

        for (int i=0; i<arr.length; i++){
            if (arr[i]==MaxCnt){
                num.add(i);
            }
        }

        System.out.println("가장많이 출현한 수: " + num.toString());
        System.out.println("최대 횟수: " + MaxCnt);


    }
    
}
