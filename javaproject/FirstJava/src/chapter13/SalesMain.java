package chapter13;

public class SalesMain {

	public static void main(String[] args) {
		
		Product p = new Product();  // 이것이 공유하는 자원이다.
		
		Customer c1 = new Customer(p);
		Customer c2 = new Customer(p);
		
		Seller seller = new Seller(p);
				
		try {
			c1.start();
			c2.start();
			Thread.sleep(5000);
			seller.start();
			
			c1.join();
			c2.join();
			
			seller.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
