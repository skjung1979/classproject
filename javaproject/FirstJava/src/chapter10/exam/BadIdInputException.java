package chapter10.exam;

public class BadIdInputException extends Exception {
	
	public BadIdInputException() {
		super("ID는 소문자, 대문자, 숫자 입력만 가능합니다.");
	}

}
