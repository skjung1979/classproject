package book.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import book.domain.Book;

//project DEPTManagerSK2
public interface Dao {

	List<Book> select(Connection conn) throws SQLException;
	List<Book> selectByBookname(Connection conn, Book book, int endPrice) throws SQLException;
	
	int insert(Connection conn, Book book) throws SQLException;
	int update(Connection conn, Book book) throws SQLException;
	int delete(Connection conn, int bookid) throws SQLException;

	
	
}
