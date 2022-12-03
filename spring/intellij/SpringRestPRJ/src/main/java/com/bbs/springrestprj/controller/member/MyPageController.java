package com.bbs.springrestprj.controller.member;

import com.bbs.springrestprj.domain.board.BoardDTO;
import com.bbs.springrestprj.domain.board.BoardListDTO;
import com.bbs.springrestprj.domain.member.Member;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

//// MemberController 클래스에서 컨트롤 함!!!!

@RestController
@RequestMapping("/mypages")
@Log4j2
public class MyPageController {

    @GetMapping
    public ResponseEntity<Member> oneMember(
            HttpSession session
    ){

        log.info("oneMember 메소드 호출...");
        log.info("session loginInfo 정보 => " + session.getAttribute("loginInfo"));




        //return new ResponseEntity(boardListDTO, HttpStatus.OK);
        return null;
    }

}
