package com.todo.todo.service.login;

import com.todo.todo.Dao.todo.Dao;
import com.todo.todo.domain.member.Member;
import com.todo.todo.domain.member.MemberRegRequest;
import com.todo.todo.domain.todo.TodoDTO;
import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    private final Dao dao;

    public LoginService(Dao dao){

        this.dao = dao;
    }

    public List<TodoDTO> getTodoList(){

        List<TodoDTO> list = new ArrayList<>();

        for (int i=0; i<10; i++){
            list.add(new TodoDTO(i+1, "todo "+i, "자세한 설명들", "2022-11-26", false));
        }

        return list;
    }


    public int insertTodo(TodoDTO todoDTO) throws Exception {
        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        result = dao.insertTodo(conn, todoDTO);

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

    public int insertTodoMember(MemberRegRequest regRequest, HttpServletRequest request) throws Exception {

        String newFileName = null;

        // 파일 업로드 처리 여부 체크
        if (regRequest.getUserphoto() != null && !regRequest.getUserphoto().isEmpty() && regRequest.getUserphoto().getSize()>0){
            // 1. uri 정의: 저장할 폴더의 uri경로를 찾는다.
            String dirURI = "/uploadfile/member";

            // 2. 시스템의 절대 경로를 찾는다.
            String dirRealPath = request.getSession().getServletContext().getRealPath(dirURI);

            // 새로운 파일명을 부여한다: 같은 이름의 파일로 업로드하는 것을 방지
            newFileName = System.nanoTime() + "_" + regRequest.getUserphoto().getOriginalFilename();

            // 3. 파일 저장
            regRequest.getUserphoto().transferTo(new File(dirRealPath, newFileName));
        }

        Member member = regRequest.toMember();

        if (newFileName != null){
            member.setUphoto(newFileName);
        }

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.insertTodoMember(conn, member);
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
