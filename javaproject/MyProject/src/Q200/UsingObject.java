package Q200;

import java.lang.reflect.Constructor;

public class UsingObject {
	
	public static void main(String[] args) {
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.println("obj1.hashCode() => " + obj1.hashCode());
		System.out.println("obj1 == obj2 => " + (obj1 == obj2));
		System.out.println("obj1.equals(obj2) => " + obj1.equals(obj2));
		System.out.println("obj1 => " + obj1);
		System.out.println("obj2.toString() => " + obj2.toString());
		
		System.out.println("obj1.getClass().getName() => " + obj1.getClass().getName());
		
		String str = obj1.getClass().getName() + "@" + Integer.toHexString(obj1.hashCode());
		System.out.println(str);
		
		Object objstr = new String("Good"); // 다형성
		System.out.println("objstr.toString() => " + objstr.toString());
		System.out.println("objstr instanceof Object => " + (objstr instanceof Object));
		System.out.println("objstr instanceof String => " + (objstr instanceof String));
		
		Class classes = obj1.getClass();
		System.out.println("classes.getName() => " + classes.getName());
		
		Constructor[] cons = classes.getDeclaredConstructors();
		for(int i=0; i<cons.length; i++) {
			System.out.println(cons[i].getName());
		}
		
	}
}
