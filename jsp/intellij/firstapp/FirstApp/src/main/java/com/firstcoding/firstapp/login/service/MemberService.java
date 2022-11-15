package com.firstcoding.firstapp.login.service;

import com.firstcoding.firstapp.login.dao.MemberDao;
import com.firstcoding.firstapp.login.dao.MemberDaoImpl;
import com.firstcoding.firstapp.login.domain.Member;
import com.firstcoding.firstapp.util.ConnectionUtil;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.rmi.ConnectIOException;
import java.sql.Connection;

@Log4j2
public class MemberService {

    private final MemberDao dao;

    // 싱글톤
    private static MemberService instance = new MemberService(); // 20번 행을으로 생성하는 것임

    // 싱글톤을 위해서 남겨 둠
    MemberService() {
        this.dao = new MemberDaoImpl();
    }

    // 변수에 final 기입하면 생성자에서 초기화 해야 함!
    MemberService(MemberDao dao) {
        this.dao = dao;
    }

    // 싱글톤: 외부에서 가져가 사용하는 메소드
    public static MemberService getInstance() {
        return instance;
    }

    public int insertMember(Member member) throws Exception {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = dao.insertMember(conn, member);

        return result;
    }

    public Member login(String uid, String pw) throws Exception {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        Member member = dao.selectByUidPw(conn, uid, pw);

        return member;
    }

    public int updateUUID(int idx, String uuid) throws Exception {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = dao.updateUUID(conn, idx, uuid);

        return result;
    }

}
