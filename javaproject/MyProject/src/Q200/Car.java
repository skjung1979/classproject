package Q200;

public class Car
{
	private int speed = 0;
	private int direction = 0;
	
	public Car()
	{
	}
	
	public void speedUp()
	{
		speed += 5;
	}
	
	public void speedDown()
	{
		speed -= 5;
	}
	
	public int curSpeed()
	{
		return speed;
	}
	
	public void turnDirect(int dir)
	{
		direction += dir;
	}
	
	public int curDirect()
	{
		return direction;
	}

	//@Override
	//public String toString() {
	//	return "Car [speed=" + speed + ", direction=" + direction + "]";
	//}
	
	

}
