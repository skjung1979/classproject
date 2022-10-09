package Q200;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CarInstanceMain {

	public static void main(String[] args) {

		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println(car1);
		System.out.println(Integer.toHexString(car1.hashCode()));
		
		Class ca = car1.getClass();
		Field[] fie = ca.getDeclaredFields();
		for(int i=0; i<fie.length; i++) {
			System.out.println(fie[i].getName());
		}
		Method[] me = ca.getDeclaredMethods();
		for(int i=0; i<me.length; i++) {
			System.out.print(me[i].getName()+" ");
			System.out.println(Modifier.isStatic(me[i].getModifiers())+" ");
			System.out.println(Modifier.isPublic(me[i].getModifiers()));
		}
		Constructor[] con = ca.getDeclaredConstructors();
		for(int i=0; i<con.length; i++) {
			System.out.println(con[i].getName());
		}

	}

}
