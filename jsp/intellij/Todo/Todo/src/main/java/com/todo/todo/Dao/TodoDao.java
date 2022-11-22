package com.todo.todo.Dao;

import com.todo.todo.domain.TodoDTO;
import com.todo.todo.member.Member;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDao implements Dao {


    public int insertTodo(Connection conn, String todo, String memo, String dueDate, boolean finished) throws SQLException {

        int result = 0;
        String sql = "insert into tododto (todo, memo, dueDates, finished) values(?, ?, ?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, todo);
        pstmt.setString(2, memo);
        pstmt.setString(3, dueDate);
        pstmt.setBoolean(4, finished);
        result = pstmt.executeUpdate();

        return result;
    }

    public List<TodoDTO> selectAll(Connection conn) throws SQLException {

        List<TodoDTO> list = new ArrayList<>();
        String sql = "select * from tododto;";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            list.add(new TodoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5)));
        }
    return list;
    }

    public TodoDTO selectBy(Connection conn, int tno) throws SQLException {
        TodoDTO tododto = null;
        String sql = "select * from tododto where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            tododto = new TodoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));
        }

        return tododto;
    }

    public int updateTodo(Connection conn, TodoDTO dto) throws SQLException {
        int result = 0;
        String sql = "update tododto set todo=?, memo=?, duedates=?, finished=? where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,dto.getTodo());
        pstmt.setString(2,dto.getMemo());
        pstmt.setString(3,dto.getDueDate());
        pstmt.setBoolean(4,dto.isFinished());
        pstmt.setLong(5,dto.getTno());

        result = pstmt.executeUpdate();

        return result;
    }

    public int deleteTodo(Connection conn, int tno) throws SQLException {

        int result = 0;
        String sql = "delete from tododto where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, tno);

        result = pstmt.executeUpdate();

        return result;
    }

    @Override
    public int insertTodoMember(Connection conn, Member member) throws SQLException {

        String sql = "insert into member_td (membernm, memberid, memberpw, memberphone, memberemail, uphoto) values (?,?,?,?,?,?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, member.getMembernm());
        pstmt.setString(2, member.getMemberid());
        pstmt.setString(3, member.getMemberpw());
        pstmt.setString(4, member.getMemberphone());
        pstmt.setString(5, member.getMemberemail());
        pstmt.setString(6, member.getUphoto());

        return pstmt.executeUpdate();
    }

    @Override
    public Member selectByUidPw(Connection conn, String userid, String userpw) throws SQLException {

        String sql = "select * from member_td where memberid=? and memberpw=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userid);
        pstmt.setString(2, userpw);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        Member member = null;

        if (rs.next()){
            member = Member.builder()
                    .seq(rs.getInt("seq"))
                    .membernm(rs.getString("membernm"))
                    .memberid(rs.getString("memberid"))
                    .memberpw(rs.getString("memberpw"))
                    .memberphone(rs.getString("memberphone"))
                    .memberemail(rs.getString("memberemail"))
                    .uuid(rs.getString("uuid"))
                    .uphoto(rs.getString("uphoto"))
                    .build();
        }

        return member;
    }

    @Override
    public int updateUUID(Connection conn, int seq, String toString) throws SQLException {

        String sql = "update member_td set uuid=? where seq=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, toString);
        pstmt.setInt(2, seq);

        int result = pstmt.executeUpdate();

        return result;
    }

    @Override
    public Member selectByUUID(Connection conn, String uuid) throws SQLException {

        String sql = "select * from member where uuid=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uuid);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        Member member = null;

        if (rs.next()){
            member = Member.builder()
                    .seq(rs.getInt("seq"))
                    .membernm(rs.getString("membernm"))
                    .memberid(rs.getString("memberid"))
                    .memberpw(rs.getString("memberpw"))
                    .memberphone(rs.getString("memberphone"))
                    .memberemail(rs.getString("memberemail"))
                    .uuid(rs.getString("uuid"))
                    .build();
        }

        return member;
    }
}
