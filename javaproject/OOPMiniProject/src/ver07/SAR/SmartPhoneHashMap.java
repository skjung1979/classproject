package ver07.SAR;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SmartPhoneHashMap implements ISmartPhone {
	private static SmartPhoneHashMap instance;
	private Map<String, Contact> dataSet;
	
	private SmartPhoneHashMap() {
		dataSet = new HashMap<String, Contact>();
	}
	
	public static SmartPhoneHashMap getInstance() {
		if(instance == null) {
			instance = new SmartPhoneHashMap();
		}
		return instance;
	}

	@Override
	public Contact findContactDataByName(String name) {
		return dataSet.get(name);
	}

	@Override
	public void deleteContactDataByName(String name) {
		if(dataSet.isEmpty()) {
			System.out.println("전화번호부 데이터가 존재하지 않습니다.");
			return;
		}
		
		if(dataSet.remove(name) == null) {
			System.out.println("삭제할 데이터가 존재하지 않습니다.");
			return;
		} else {
			System.out.println(name + " 데이터 삭제가 완료되었습니다.");			
		}
	}

	@Override
	public void insertContactData(Contact data) {
		if(data == null) {
			System.out.println("데이터 확인 필요.");
			return;
		}

		dataSet.put(data.getName(), data);
	}

	@Override
	public void updateContactData(Contact data) {
		if(data == null) {
			System.out.println("데이터 확인 필요.");
			return;
		}
		if(dataSet.isEmpty()) {
			System.out.println("전화번호부 데이터가 존재하지 않습니다.");
			return;
		}
		
		dataSet.put(data.getName(), data);
	}

	@Override
	public Contact findContactDataByNameAndPhoneNumber(String name, String phoneNum) {
		Contact data = dataSet.get(name);
		
		if(data != null && data.getPhoneNumber().equals(phoneNum)) {
			return data;
		}
		
		return null;
	}

	@Override
	public void printContactAllData() {
		if(dataSet.isEmpty()) {
			System.out.println("전화번호부 데이터가 존재하지 않습니다.");
			return;
		}
		
		Set<String> keySet = this.dataSet.keySet();
		
		for(String key: keySet) {
			dataSet.get(key).showData();
		}
	}

}