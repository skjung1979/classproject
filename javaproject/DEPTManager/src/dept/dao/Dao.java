package dept.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import dept.domain.Dept;

public interface Dao {
	
	// 컨드롤러에서 정의한 메소드들...
	List<Dept> select(Connection conn) throws SQLException;
	Dept selectByDeptno(Connection conn, int deptno) throws SQLException;
	
	// DML => int 결과
	int insert(Connection conn, Dept dept) throws SQLException;	// 여러개를 받는 경우 Dept dept
	int update(Connection conn, Dept dept) throws SQLException;
	int delete(Connection conn, int deptno) throws SQLException;	// 하나만 받는 경우
	
}
