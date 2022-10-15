package chapter11.second;

import java.util.HashMap;
import java.util.Set;

public class HashMatTest {

	public static void main(String[] args) {

		HashMap<String, SmartPhone> hashMap = new HashMap<>();
		
		// 키값 대,소문자 구분해서 입력해야함
		hashMap.put("Sp", new SmartPhone("Spring","010-1111-1111"));
		hashMap.put("Kg", new SmartPhone("king","010-1223-1111"));
		hashMap.put("Sn", new SmartPhone("Son","010-1114-1111"));
		hashMap.put("Kg", new SmartPhone("king","010-7777-1111"));
		// 데이터가 중복되면 뒤 데이터의 값으로 put됨
		
		System.out.println(hashMap.get("Kg"));
		
		System.out.println("========================");
		
		HashMap<Integer, SmartPhone> hashMap2 = new HashMap<>();
		hashMap2.put(1, new SmartPhone("Spring","010-1111-1111"));
		hashMap2.put(2, new SmartPhone("king","010-1223-1111"));
		hashMap2.put(3, new SmartPhone("Son","010-1114-1111"));
		hashMap2.put(4, new SmartPhone("king","010-7777-1111"));
		
		System.out.println(hashMap2.get(3));
		
		System.out.println("========================");
		
		// 키값들을 Set 객체로 받는다.
		Set<String> keySet = hashMap.keySet();
		
		for (String key : keySet) {
			System.out.println(key + " - " + hashMap.get(key));
		}

	}

}
