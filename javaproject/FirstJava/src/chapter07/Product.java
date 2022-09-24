package chapter07;

public class Product {

	int price;
	int point;
	
	Product(int price){
		this.price = price;
		this.point = price/10;
	}
	
}


class TV extends Product{

	TV(int price) {
		super(price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TV";
	}
}

class Computer extends Product{

	Computer(int price) {
		super(price);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Computer";
	}
}












