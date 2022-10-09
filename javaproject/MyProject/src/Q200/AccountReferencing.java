package Q200;

public class AccountReferencing {

	public static void main(String[] args) {

		Account acc1 = new Account(10000);
		Account acc2 = new Account(20000);
		
		System.out.println(Integer.toHexString(acc1.hashCode()));
		System.out.println(acc1);
		System.out.println(acc2);
		acc1.deposit(30000);
		System.out.println(acc1.getMoney());


	}

}
