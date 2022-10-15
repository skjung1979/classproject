package chapter11.second;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap<String, SmartPhone> hashMap = new HashMap<>();
		
		hashMap.put("A", new SmartPhone("Spring", "010-1111-1111"));
		hashMap.put("B", new SmartPhone("Summer", "010-2222-1111"));
		hashMap.put("C", new SmartPhone("Fall", "010-3333-1111"));
		hashMap.put("D", new SmartPhone("Winter", "010-4444-1111"));
		
		System.out.println(hashMap.get("A").getName());
		
		System.out.println("==================");
		
		HashMap<Integer, SmartPhone> hashMap2 = new HashMap<>();
		
		hashMap2.put(1, new SmartPhone("Spring", "010-1111-1111"));
		hashMap2.put(2, new SmartPhone("Summer", "010-2222-1111"));
		hashMap2.put(3, new SmartPhone("Fall", "010-3333-1111"));
		hashMap2.put(4, new SmartPhone("Winter", "010-4444-1111"));
		
		System.out.println(hashMap2.get(2).getName());
		
		System.out.println("==================");
		
		Set<Integer> key = hashMap2.keySet();
		
		for (Integer k : key) {
			System.out.println(k + " + " + hashMap2.get(k).getName() + " + " + hashMap2.get(k).getPhoneNumber());
		}

	}

}
