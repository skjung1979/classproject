package chapter07;

public class Buyer {

	int money; // 상수 변수 대문자
	int myPoint;
	
	Buyer(int money){
		this.money = money;
	}
	
	void buy(Product p) { // 모든 물품을 커버하는 타입 Product
		
		money = money - p.price; // 내가 가진돈은 차감
		// 포인트는 증가
		myPoint += p.point;
		System.out.println(p+"제품을 구매했습니다.");
		// p는 p.toString()를 호출한다.
	}
	
	public static void main(String[] args) {
		// 제품 만들기: TV 인스턴스, Computer 인스턴스
		TV tv = new TV(100);
		Computer com = new Computer(200);
		
		// 다형성
		Product p1 = tv;
		Product p2 = com;
		
		// 다형성을 이용한 배열, 제품 진열		
		Product[] products = new Product[5];
		products[0] = new TV(100);	// 상위 타입에 하위 인스턴스를 대입한다.
		products[1] = new Computer(200);
		products[2] = new Computer(200);
		products[3] = new Computer(200);
		products[4] = new TV(100);
		
		System.out.println("판매 상품 리스트");
		for(int i=0;i<products.length;i++) {
			System.out.println(products[i] + " 가격: " + products[i].price);
		}
		System.out.println("--------------------");
		
		
		// 구매자 생성
		Buyer buyer = new Buyer(1000);
		
		// 구매 테스트
		buyer.buy(tv);
		buyer.buy(p2);
		buyer.buy(p1);
		buyer.buy(com);
		
	}
	
	
}
