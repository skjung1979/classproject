package com.todo.todospring.mapper;

import com.todo.todospring.domain.TodoDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("Select * from tododto")
    List<TodoDTO> selectAll() throws SQLException;

    @Select("Select * from tododto where tno=#{tno}")
    TodoDTO selectByTno(long tno) throws SQLException;

    int insertToDo(TodoDTO dto) throws SQLException;

    int updateTodo(TodoDTO dto) throws SQLException;

    @Delete("delete from tododto where tno=#{tno}")
    int deleteTodo(long dto) throws SQLException;

}
