package com.todo.todomybatis.service.todo;

import com.todo.todomybatis.domain.todo.TodoDTO;
import com.todo.todomybatis.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    public int insertTodo(TodoDTO todoDTO) throws Exception {

        return todoMapper.insertTodo(todoDTO);
    }

    public List<TodoDTO> selectAll() throws Exception {

        return todoMapper.selectAll();
    }

    public TodoDTO selectBy(int tno) throws Exception {

        return todoMapper.selectBy(tno);
    }

    public int updateTodo(TodoDTO dto) throws Exception {

        return todoMapper.updateTodo(dto);
    }

    public int deletTodo(int tno) throws Exception {

        return todoMapper.deleteTodo(tno);
    }


}
