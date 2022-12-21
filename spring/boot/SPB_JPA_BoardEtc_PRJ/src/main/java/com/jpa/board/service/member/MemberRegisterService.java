package com.jpa.board.service.member;

import com.jpa.board.domain.MemberRegisterRequest;
import com.jpa.board.entity.member.Member;
import com.jpa.board.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
@Log4j2
public class MemberRegisterService {

    @Autowired
    private MemberRepository memberRepository;


    public int insertMember(MemberRegisterRequest memberRegisterRequest) {

        MultipartFile file = memberRegisterRequest.getMphoto();

        log.info(".getMphoto().................. ==> " + memberRegisterRequest.getMphoto());

        File saveDir = null;
        String newFileName = null;

        if (file != null && !file.isEmpty() && file.getSize()>0){
            String absolutPath = new File("").getAbsolutePath();
            log.info("absolutPate............ ==> " + absolutPath);

            String path = "mphoto";
            saveDir = new File(absolutPath, path);

            if (!saveDir.exists()){
                saveDir.mkdir();
                log.info("mphoto 디렉토리 생성 완료");
            }

            String nano = String.valueOf(System.nanoTime());
            newFileName = nano + "_" + file.getOriginalFilename();

            File newFile = new File(saveDir, newFileName);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        log.info("memberRegisterRequest............. ==> " + memberRegisterRequest.toString());

        Member member = memberRegisterRequest.toMember();

        member.setMphoto(newFileName);
        member.setRole("USER"); // 추후 "ADMIN"과 구분하여 사용
        member.setRegdate(LocalDateTime.now());


        log.info("member............. ==> " + member.toString());

        int result = memberRepository.save(member) != null ? 1 : 0;

        return result;
    }
}
