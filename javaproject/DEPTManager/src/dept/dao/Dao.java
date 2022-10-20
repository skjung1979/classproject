package dept.dao;

import java.sql.Connection;
import java.util.List;
import dept.domain.Dept;

public interface Dao {
	
	// 컨드롤러에서 정의한 메소드들...
	List<Dept> select(Connection conn);
	Dept selectByDeptno(Connection conn, int deptno);
	
	// DML => int 결과
	int insert(Connection conn, Dept dept);	// 여러개를 받는 경우
	int update(Connection conn, Dept dept);
	int delete(Connection conn, int deptno);	// 하나만 받는 경우
	
}
