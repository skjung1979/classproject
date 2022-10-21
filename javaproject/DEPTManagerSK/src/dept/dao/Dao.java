package dept.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dept.domain.Dept;

//project DEPTManagerSK
public interface Dao {
	
	// 메소드들을 인터페이스에서 정의해서 OracleDao.java에서 상속받아 구현한다.
	List<Dept> select(Connection conn) throws SQLException;
	
	Dept selectByDeptno(Connection conn, int deptno) throws SQLException;
	
	int insert(Connection conn, Dept dept) throws SQLException;
	
	int update(Connection conn, Dept dept) throws SQLException;
	
	int delete(Connection conn, int deptno) throws SQLException;

}
