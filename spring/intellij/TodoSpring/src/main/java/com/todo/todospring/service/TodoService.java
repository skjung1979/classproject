package com.todo.todospring.service;

import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Log4j2
@Service
public class TodoService {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    public List<TodoDTO> getTodoList() throws SQLException {

        List<TodoDTO> list = null;

        list = todoMapper.selectAll();

        log.info(list);

        //list = Collections.emptyList();

        return list;
    }

    public TodoDTO getTodo(long tno) throws SQLException {

        return todoMapper.selectByTno(tno);
    }

    public int insertTodo(TodoDTO todoDTO) throws SQLException {

        return todoMapper.insertToDo(todoDTO);
    }

    public int modify(TodoDTO todoDTO) throws SQLException {

        return todoMapper.updateTodo(todoDTO);
    }

    public int deleteBytno(long tno) throws SQLException {

        return todoMapper.deleteTodo(tno);
    }
}
