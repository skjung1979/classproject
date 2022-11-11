import com.firstcoding.firstapp.util.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

    @Test
    public void testConnection() throws Exception {

        // 테스트에 문제가 없는지 확인 후 실제 파일에 복붙한다.

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/project", "scott", "tiger");

        Assertions.assertNotNull(conn);

        conn.close();

    }

    @Test
    public void testPoolConnections() throws Exception {

        Connection conn = ConnectionUtil.getInstance().getConnection();

        System.out.println(conn);

        Assertions.assertNotNull(conn);

        conn.close();

    }


}
