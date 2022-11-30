package com.bbs.springrestprj.service.member;

import com.bbs.springrestprj.domain.member.Member;
import com.bbs.springrestprj.domain.member.MemberRegRequest;
import com.bbs.springrestprj.mapper.MemberRegMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Service
@Log4j2
public class MemberRegService {

    @Autowired(required = false)
    private MemberRegMapper memberRegMapper;

    public int insertMember(MemberRegRequest regRequest, HttpServletRequest request) throws Exception {

        String newFileName = null;

        // 파일 업로드 처리 여부 체크
        if (regRequest.getUserphoto() != null && !regRequest.getUserphoto().isEmpty() && regRequest.getUserphoto().getSize()>0){
            // 1. uri 정의: 저장할 폴더의 uri경로를 찾는다.
            String dirURI = "/uploadfile/member";

            // 2. 시스템의 절대 경로를 찾는다.
            String dirRealPath = request.getSession().getServletContext().getRealPath(dirURI);

            // 새로운 파일명을 부여한다: 같은 이름의 파일로 업로드하는 것을 방지
            newFileName = System.nanoTime() + "_" + regRequest.getUserphoto().getOriginalFilename();

            log.info("실제 경로 dirRealpath => " + dirRealPath);

            // 3. 파일 저장
            regRequest.getUserphoto().transferTo(new File(dirRealPath, newFileName));
        }

        Member member = regRequest.toMember();

        if (newFileName != null){
            member.setUphoto(newFileName);
        }

        return memberRegMapper.insertMember(member);
    }
}
