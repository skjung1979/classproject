package Q200;

public class AccountsMain {

	public static void main(String[] args) {

		Account acc1 = new Account(500000);
		acc1.deposit(50000);
		acc1.deposit(300);
		acc1.withdraw(30000);
		System.out.println("잔액은? " + acc1.getMoney()+"원");
		
	}

}
