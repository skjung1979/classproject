package chapter04;

public class IfTest {

    public static void main(String[] args) {

	int score = 69;
	
	// 60점 이상이면 PASS를 출력하자.
	if (score>=60) {
	    System.out.println("PASS");
	}
	
	// 60점 이상이면 PASS 출력, 60점 미만 이면 FAIL 출력
	if (score>=60) {
	    // 조건식의 결과가 true일때 처리되는 구문
	    System.out.println("PASS");
	}else {
	    // 조건식의 결과가 false일때 처리되는 구문
	    System.out.println("FAIL");
	}
	
	// 90점 이상이면 A 출력, 80점 이상이면 B를 출력, 70점 이상이면 C, 나머지는 FAIL
	if (score>=90) {
	    // 90점 이상 만족하면 A
	    System.out.println("A");
	}else if (score>=80) {
	    // 90점 미만 중에 80점 이상이면 참
	    System.out.println("B");
	}else if (score>=70) {
	    // 80점 미만 중에 70점 이상이면 참
	    System.out.println("C");
	}else {
	    // 70점 미만이면 참
	    System.out.println("FAIL");
	}
	
    }

}
