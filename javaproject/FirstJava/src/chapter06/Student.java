package chapter06;
//=================== 챕터 06-2 강사님 문제풀이 =============
public class Student {

	/*
	 * 2. Student 클래스를 정의해봅시다. ① 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다. ② 변수는 캡슐화를
	 * 합니다. getter/setter 메소드를 정의합니다. ③ 총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
	 */
	
	private String name;
	private int korScore;
	private int engScore;
	private int mathScore;
	
	// 생성자 자동 생성
	public Student(String name, int korScore, int engScore, int matScore) {
		super();
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = matScore;
	}

	// getter / setter 자동 생성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMatScore(int matScore) {
		this.mathScore = matScore;
	}
	
	// 총점을 구해서 반환하는 메소드
	public int sum() // 총점이 얼마나 되는지 범위를 생각해서 변수 타입 표기
	{
		int result = korScore + engScore + mathScore;
		
		return result;
	}
	
	// 평균을 구해서 반환하는 메소드
	public float avg()
	{
		return sum()/3f;
	}
	
	// 행단위 출력하기
	public void printData()
	{
		System.out.print(this.name + "\t" + this.korScore + "\t" + this.engScore + "\t" + this.mathScore + "\t" + sum() + "\t" + avg()+"\n"); // 학생이름, 국어, 영어, 수학, 총점, 평균
	}

	// main 메소드
	public static void main(String[] args) {
		
		Student s = new Student("학생1", 100, 91, 80);
		System.out.println("합: "+ s.sum());
		System.out.println("평균: "+ s.avg());
		
		s.printData();
		
	}
	
}




















