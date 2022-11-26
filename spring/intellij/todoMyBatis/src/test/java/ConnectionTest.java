import com.todo.todomybatis.mapper.TimeMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private TimeMapper timeMapper;

    @Test
    public void connectionTest() throws SQLException {

        Connection connection = dataSource.getConnection();

        //log.info(connection); 왜 로그 실행이 에러나지??....

        Assertions.assertNotNull(connection);

        connection.close();
    }

    @Test
    public void getTime(){

        // log.info(timeMapper.getTime());

        System.out.println(timeMapper.getTime());

    }

}
