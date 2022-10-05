package Q200;

public class Account
{	
	private double money = 5000;
	
	public Account(double money)
	{
		this.money = money;
	}
	
	public Account()
	{
		
	}
	
	public double getMoney()
	{
		return money;
	}
	
	public void withdraw(double amount)
	{
		if(amount>0 && (money-amount)>0)
		{
			money -= amount;
		}
	}
	
	public void deposit(double amount)
	{
		if(amount>0)
		{
			money += amount;
		}
	}

}
