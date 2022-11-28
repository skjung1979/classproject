import com.sun.tools.javac.comp.Todo;
import com.todo.todospring.domain.Member;
import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.mapper.MemberMapper;
import com.todo.todospring.mapper.TodoMapper;
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
import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class) // 스프링 컨테이너 구동
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void deleteTodoTest() throws SQLException {

        int result = todoMapper.deleteTodo(25);

        Assertions.assertEquals(1, result);

    }


    @Test
    public void updateTodoTest() throws SQLException {

        TodoDTO todoDTO =  TodoDTO.builder()
                .tno(27)
                .todo("단위테스트_수정함")
                .duedates(LocalDate.now())
                .finished(true)
                .build();

        int result = todoMapper.updateTodo(todoDTO);

        Assertions.assertEquals(1,result);

    }

    @Test
    public void insertTodoTest() throws SQLException {

        TodoDTO todoDTO =  TodoDTO.builder()
                .todo("단위테스트")
                .duedates(LocalDate.now())
                .build();

        int result = todoMapper.insertToDo(todoDTO);

        Assertions.assertEquals(1,result);

    }

    @Test
    public void selectByTnoTest() throws SQLException {

        TodoDTO todoDTO = todoMapper.selectByTno(7);

        log.info(todoDTO);

        Assertions.assertNotNull(todoDTO);

    }

    @Test
    public void selectAllTest() throws SQLException {

        List<TodoDTO> list = todoMapper.selectAll();

        log.info(list);

    }

    @Test
    public void insertMemberTest() throws SQLException {

        Member member = Member.builder()
                .uid("aja")
                .pw("123")
                .uname("SSON")
                .build();

        int result = memberMapper.insertMember(member);

        Assertions.assertEquals(1, result); // 1 == result가 같아야 문제 없는 것!

    }

    @Autowired(required = false)
    private MemberMapper memberMapper;

    @Test
    public void selectByIpPwTest() throws SQLException {
        Member member = memberMapper.selectByIdPw("aaas", "aaa");

        log.info(member);

        Assertions.assertNull(member);


    }


    @Test
    public void connectionTest() throws SQLException {

        Connection conn = dataSource.getConnection();

        log.info(conn);

        Assertions.assertNotNull(conn);

        conn.close();

    }

}
