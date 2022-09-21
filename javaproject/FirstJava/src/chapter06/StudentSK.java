package chapter06;

// ========== 챕터 06-2 문제풀이 JSK ==============

public class StudentSK {

	/*
	 * 2. Student 클래스를 정의해봅시다.
	 * ① 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다. ok
	 * ② 변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다. ok
	 * ③ 총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
	 */
	
	// ① 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
	// ② 변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
	private String name;
	private int korSco;
	private int engSco;
	private int mathSco;
	
	// 생성자 자동 생성
	public StudentSK(String name, int korSco, int engSco, int mathSco) {
		super();
		this.name = name;
		this.korSco = korSco;
		this.engSco = engSco;
		this.mathSco = mathSco;
	}

	// getter, setter 자동 생성 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorSco() {
		return korSco;
	}

	public void setKorSco(int korSco) {
		this.korSco = korSco;
	}

	public int getEngSco() {
		return engSco;
	}

	public void setEngSco(int engSco) {
		this.engSco = engSco;
	}

	public int getMathSco() {
		return mathSco;
	}

	public void setMathSco(int mathSco) {
		this.mathSco = mathSco;
	}
	
	// ③ 총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
	// 총점 구해서 반환(return)
	public int sum()
	{
		return korSco + engSco + mathSco;
	}
	
	// 평균 구해서 반환(return)
	public float avg()
	{
		return sum()/3f;
	}
	
	// 한 줄에 출력하기 (반환X=void)
	public void printLine()
	{
		// 학생이름, 국어, 영어, 수학, 총점, 평균
		System.out.print(this.name+"\t"+this.korSco+"\t"+this.engSco+"\t"+this.mathSco+"\t"+sum()+"\t"+avg()+"\n");
	}

}
