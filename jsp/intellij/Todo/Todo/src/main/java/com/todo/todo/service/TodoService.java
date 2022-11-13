package com.todo.todo.service;

import com.todo.todo.domain.TodoDTO;

import java.util.ArrayList;
import java.util.List;

public class TodoService {

    public List<TodoDTO> getTodoList(){

        List<TodoDTO> list = new ArrayList<>();

        for (int i=0; i<10; i++){
            list.add(new TodoDTO(i+1, "todo "+i, "자세한 설명들", "2022-11-26", false));
        }

        return list;
    }



}
