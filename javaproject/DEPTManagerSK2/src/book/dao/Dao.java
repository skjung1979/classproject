package book.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import book.domain.Book;

//project DEPTManagerSK2
public interface Dao {

	List<Book> select(Connection conn) throws SQLException;
	Book selectByBookname(Connection conn, Book bookname);
	
	int insert(Connection conn, Book book);
	int update(Connection conn, Book book);
	int delete(Connection conn, int bookid);
	
	
}
