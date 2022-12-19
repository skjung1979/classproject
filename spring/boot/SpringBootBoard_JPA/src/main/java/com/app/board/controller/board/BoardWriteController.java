package com.app.board.controller.board;

import com.app.board.domain.BoardWriteRequest;
import com.app.board.security.CustomUser;
import com.app.board.service.board.BoardWriteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@Log4j2
@RequestMapping("/board/write")
public class BoardWriteController {

    @Autowired
    private BoardWriteService boardWriteService;

    @GetMapping
    public void writeForm(){

    }

    @PostMapping
    public String write(
            BoardWriteRequest boardWriteRequest
    ){

        log.info("boardWriteRequest................ => " + boardWriteRequest);

        // 해당 프로젝트의 절대 경로
        String absolutePath = new File("").getAbsolutePath();
        log.info(">>>>>>>>>> absolutPath path: " + absolutePath);

        boardWriteService.write(boardWriteRequest);

        return "redirect:/board/list";
    }

}
