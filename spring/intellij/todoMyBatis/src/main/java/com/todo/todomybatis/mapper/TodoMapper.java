package com.todo.todomybatis.mapper;

import com.todo.todomybatis.domain.todo.TodoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

@Mapper
public interface TodoMapper {
    int insertTodo(TodoDTO todoDTO);

    //@Sql("select * from tododto")
    List<TodoDTO> selectAll();

    TodoDTO selectBy(int tno);

    int updateTodo(TodoDTO dto);

    int deleteTodo(int tno);
}
