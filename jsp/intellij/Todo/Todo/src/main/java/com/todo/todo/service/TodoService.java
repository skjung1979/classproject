package com.todo.todo.service;

import com.todo.todo.Dao.Dao;
import com.todo.todo.Dao.TodoDao;
import com.todo.todo.domain.TodoDTO;
import com.todo.todo.member.Member;
import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final Dao dao;

    public TodoService(Dao dao){
        this.dao = dao;
    }


    public List<TodoDTO> getTodoList(){

        List<TodoDTO> list = new ArrayList<>();

        for (int i=0; i<10; i++){
            list.add(new TodoDTO(i+1, "todo "+i, "자세한 설명들", "2022-11-26", false));
        }

        return list;
    }


    public int insertTodo(String todo, String memo, String dueDate, boolean finished) throws Exception {
        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        result = dao.insertTodo(conn, todo, memo, dueDate, finished);

        return result;
    }

    public List<TodoDTO> selectAll() throws Exception {

        List<TodoDTO> list = new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        list = dao.selectAll(conn);

        return list;
    }

    public TodoDTO selectBy(int tno) throws Exception {
        TodoDTO tododto = new TodoDTO();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        tododto = dao.selectBy(conn, tno);

        return tododto;
    }

    public int updateTodo(TodoDTO dto) throws Exception {

        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        result = dao.updateTodo(conn, dto);

      return result;
    }

    public int deletTodo(int tno) throws Exception {

        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        result = dao.deleteTodo(conn, tno);

        return result;
    }

    public int insertTodoMember(Member member) throws Exception {

        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        result = dao.insertTodoMember(conn, member);

        return 0;
    }

    public Member login(String userid, String userpw) throws Exception {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        Member member = dao.selectByUidPw(conn, userid, userpw);

        return member;
    }

    public int updateUUID(int seq, String toString) throws Exception {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = dao.updateUUID(conn, seq, toString);

        return result;
    }

    public Member selectByUUID(String uuid) throws Exception {

        Member member = new Member();
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();
        member = dao.selectByUUID(conn, uuid);

        return member;
    }
}
