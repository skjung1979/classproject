

import org.junit.jupiter.api.Test;
import java.sql.SQLException;

public class ConnectionTest {

    @Test
    public void testConnections() throws ClassNotFoundException, SQLException {

        // 실제로는 여기서 예외 처리를 해야하지만, 테스트 이므로 예외를 호출한 곳에서 처리하도록 던진다!
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 실제로는 여기서 예외 처리를 해야하지만, 테스트 이므로 예외를 호출한 곳에서 처리하도록 던진다!
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project", "scott", "tiger");

        //Assertions.assertNotNull(conn);

    }

    @Test
    public void testPoolConnections() throws Exception {
        //Connection conn = ConnectionUtil.getInstance().getConnection();

        //System.out.println(conn);

        //Assertions.assertNotNull(conn);

        //conn.close();
    }

}
