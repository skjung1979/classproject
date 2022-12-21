package com.jpa.board.controller.board;

import com.jpa.board.domain.BoardWriteRequest;
import com.jpa.board.entity.board.Board;
import com.jpa.board.service.board.BoardWriteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequestMapping("/board/write")
public class BoardWriteController {

    @Autowired
    private BoardWriteService boardWriteService;

    @GetMapping
    public void getBoardWrite(
            HttpServletRequest request,
            Model model
    ){

        HttpSession session = request.getSession();

        model.addAttribute("loginInfo", session.getAttribute("loginInfo"));
    }

    @PostMapping
    public String postBoardWrite(
            BoardWriteRequest boardWriteRequest
    ){

        log.info("boardWriteRequest .......................... ==> " + boardWriteRequest.toString());


        boardWriteService.writeBoard(boardWriteRequest);

        return "redirect:/";
    }

}
