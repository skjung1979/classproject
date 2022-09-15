package chapter04;

public class IfTest2 {

    public static void main(String[] args) {

	// 짝수 홀수 판별
	int num1 = 11;
	
	if(num1%2 == 0) {
	    System.out.println("짝수");
	}else {
	    System.out.println("홀수");
	}
	
	int num2 = -7;
	
	// 양수, 0, 음수
	if (num2 > 0) {
	    System.out.println("양수");
	}else if(num2 == 0) {
	    System.out.println("0");
	}else {
	    System.out.println("음수");
	}
	
	
    }

}
