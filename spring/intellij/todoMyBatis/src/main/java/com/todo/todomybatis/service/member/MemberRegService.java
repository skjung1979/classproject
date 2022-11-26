package com.todo.todomybatis.service.member;

import com.todo.todomybatis.domain.member.Member;
import com.todo.todomybatis.domain.member.MemberRegRequest;
import com.todo.todomybatis.mapper.MemberRegMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Service
public class MemberRegService {

    @Autowired
    private MemberRegMapper memberRegMapper;

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

        //@Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return memberRegMapper.insertTodoMember(member);
    }
}
