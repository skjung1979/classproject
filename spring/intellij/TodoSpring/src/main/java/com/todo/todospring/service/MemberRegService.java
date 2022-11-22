package com.todo.todospring.service;

import com.todo.todospring.dao.MemberDao;
import com.todo.todospring.domain.Member;
import com.todo.todospring.domain.MemberRegRequest;
import com.todo.todospring.util.ConnectionProvider;
import lombok.Cleanup;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

@Log4j2
@Service
public class MemberRegService {

    @Autowired
    private MemberDao memberDao;

    // 사용자 요청 데이터를 받고, 파일 업로드 처리, Dao insert 요청
    public int memberReg(MemberRegRequest regRequest, HttpServletRequest request) throws Exception {

        String newFileName = null;

        // 파일 업로드 처리 여부 체크
        if (regRequest.getUphoto() != null && !regRequest.getUphoto().isEmpty() && regRequest.getUphoto().getSize()>0){
            
            // 1. URI 정의: 저장할 폴더의 uri 경로를 찾기
            String dirURI = "/uploadfile/member";
            // 2. 시스템의 절대 경로 찾기
            String dirRealpath = request.getSession().getServletContext().getRealPath(dirURI);
            log.info(dirRealpath);

            // 새로운 파일명: 파일 이름이 겹치는 경우를 방지하기 위해
            newFileName = System.nanoTime() + "_" + regRequest.getUphoto().getOriginalFilename();

            log.info(newFileName);

            // 3. 저장
            try {
                //regRequest.getUphoto().transferTo(new File(dirRealpath, regRequest.getUphoto().getOriginalFilename()));
                regRequest.getUphoto().transferTo(new File(dirRealpath, newFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        Member member = regRequest.toMember();

        if (newFileName != null){
            member.setUphoto(newFileName);
        }

        log.info(member);

        @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();

        return memberDao.insertMember(conn, member);
    }
}
