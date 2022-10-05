package ver07.SAR;

interface ISmartPhone {

	/**
	 * 이름으로 데이터 찾는 함수
	 * 
	 * @param name
	 * @return
	 */
	abstract Contact findContactDataByName(String name);

	/**
	 * 이름으로 데이터 삭제하는 함수
	 * 
	 * @param name
	 */
	abstract void deleteContactDataByName(String name);

	/**
	 * 데이터 입력 함수
	 * 
	 * @param data
	 */
	abstract void insertContactData(Contact data);

	/**
	 * 데이터 수정 함수
	 * 
	 * @param data
	 */
	abstract void updateContactData(Contact data);

	/**
	 * name, phoneNumber와 동일한 데이터를 반환하는 함수
	 * 
	 * @param name
	 * @param phoneNum
	 * @return
	 */
	abstract Contact findContactDataByNameAndPhoneNumber(String name, String phoneNum);

	/**
	 * 모든 데이터 print
	 */
	abstract void printContactAllData();
}