package dept.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dept.domain.Dept;

public class OracleDao implements Dao {

	@Override
	public List<Dept> select(Connection conn) throws SQLException {

		List<Dept> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();	// 예외는 서비스 계층에서 하도록 던진다

			String sql = "select * from dept";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// 이 메소드의 핵심 기능: 각 행의 데이터를 Dept 객체로 생성 -> List에 추가
				//list.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
				list.add(rowToDept(rs));	// 반복되어 메소드롤 생성하여 넣는다.
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return list;
	}

	@Override
	public Dept selectByDeptno(Connection conn, int deptno) throws SQLException {

		Dept dept = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from dept where deptno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);

			rs = pstmt.executeQuery();

			if (rs.next()) { // 결과가 하나라서... 여러개이면 while 돌린다.
				//dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				dept = rowToDept(rs);
			} 
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return dept;
	}
	
	@Override
	public int insert(Connection conn, Dept dept) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into dept values(?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno()); 
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());

			result = pstmt.executeUpdate(); // int로 반환 된다.
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	@Override
	public int update(Connection conn, Dept dept) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "update dept set dname=?, loc=? where deptno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());

			result = pstmt.executeUpdate(); // int로 반환 된다.
		} finally {	
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return result;
	}

	@Override
	public int delete(Connection conn, int deptno) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from dept where deptno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);

			result = pstmt.executeUpdate(); // int로 반환 된다.
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}
	
	// dept 반환 메소드
	private Dept rowToDept(ResultSet rs) throws SQLException {
		return new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
	}
}


















