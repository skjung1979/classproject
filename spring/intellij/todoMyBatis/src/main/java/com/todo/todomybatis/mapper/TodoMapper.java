package com.todo.todomybatis.mapper;

import com.todo.todomybatis.domain.todo.TodoDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface TodoMapper {
    int insertTodo(TodoDTO todoDTO);

    @Select("select * from tododto")
    List<TodoDTO> selectAll();

    @Select("select * from tododto where tno=#{tno}")
    TodoDTO selectBy(int tno);

    int updateTodo(TodoDTO dto);

    @Delete("delete from tododto where tno=#{tno}")
    int deleteTodo(int tno);
}
