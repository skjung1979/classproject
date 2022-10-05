package chapter11;

import java.util.HashMap;
import java.util.Set;

public class HashMapTestSK2 {

	public static void main(String[] args) {
		
		HashMap<String, SmartPhoneSK2> hashMap = new HashMap<>();
		
		hashMap.put("Spring", new SmartPhoneSK2("Spring", "010-1111-1111"));
		hashMap.put("King", new SmartPhoneSK2("King", "010-9999-3333"));
		hashMap.put("Son", new SmartPhoneSK2("Son", "010-1122-1111"));
		hashMap.put("King", new SmartPhoneSK2("King", "010-7777-3333"));
		
		System.out.println(hashMap.get("Son"));
		System.out.println(hashMap.get("son"));
		
		System.out.println("================");
		
		// 키 값들을 Set 객체로 받는다.
		Set<String> keySet = hashMap.keySet();
		
		for(String key : keySet) {
			System.out.println(key+ " => " + hashMap.get(key));
		}
		
	}
	
}

