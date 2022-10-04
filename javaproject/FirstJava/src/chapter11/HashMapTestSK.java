package chapter11;

import java.util.HashMap;
import java.util.Set;

public class HashMapTestSK {
	
	public static void main(String[] args) {
		
		HashMap<String, SmartPhoneSK> hashMap = new HashMap<>();
		
		hashMap.put("Spring", new SmartPhoneSK("Spring","010-1111-1111"));
		hashMap.put("Summer", new SmartPhoneSK("Summer","010-1111-1111"));
		hashMap.put("Fall", new SmartPhoneSK("Fall","010-1111-1111"));
		
		System.out.println(hashMap.get("fall"));
		System.out.println(hashMap.get("Fall"));
		
		System.out.println("===============");
		
		// 키 값들을 Set 객체로 받는다.
		Set<String> keySet = hashMap.keySet();
		
		for(String key : keySet) {
			// 모든 데이타를 가져온다.
			System.out.println(key + " = " + hashMap.get(key));
			
		}
		
	}

}
