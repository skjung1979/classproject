//주행 후 소모된 기릅값을 계산합니다.
//주행거리, 주유소기름값, 주행연비를 입력 받습니다.
package testtest;
import java.util.Scanner;
public class CalOil {

	public static void main(String[] args) {
	
		System.out.println("주행거리, 주유소기름값, 주행연비 값을 입력하세요:");
		
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt(); //총 주행거리
		int b = scanner.nextInt(); //주유소 기름값
		double c = scanner.nextDouble(); //차량 주행 연비
		int d = (int)a/(int)c*(int)b;

		System.out.println("발생한 기름값은 "+d+"원 입니다.");
	
		scanner.close();
			
	}
}
