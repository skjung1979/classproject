package dept.domain;

// DTO: Java Beans 형식으로 정의한다.
// DTO 정의 조건: 모든 변수 private, 기본생성자 필존, getter/setter메소드 존재!

public class Dept {
	
	// 변수 선언: DB컬럼명과 일치하는 것이 좋다.
	private int deptno;
	private String dname;
	private String loc;
	
	public Dept() {
		super();
	}
	
	public Dept(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	@Override
	public String toString() {
		
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}
