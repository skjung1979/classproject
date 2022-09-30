package chapter11;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<String, SmartPhone> hashMap = new HashMap<>();
		
		hashMap.put("Spring", new SmartPhone("Spring", "010-0000-0000"));
		hashMap.put("king", new SmartPhone("king", "010-1111-0000"));
		
		System.out.println(hashMap.get("king"));		
		
		System.out.println("====================");
		
		hashMap.put("Song", new SmartPhone("Song", "010-2222-0000"));
		hashMap.put("king", new SmartPhone("king", "010-7777-0000"));
		
		System.out.println(hashMap.get("Song"));
		System.out.println(hashMap.get("song"));
		System.out.println(hashMap.get("king"));
		
		System.out.println("====================");
		
		// 키 값들을 Set객체로 받는다.
		Set<String> keySet = hashMap.keySet();
		
		for(String key : keySet) {
			//System.out.println(key);
			System.out.println(key+ " = " + hashMap.get(key));
		}
		
	}
	
}
