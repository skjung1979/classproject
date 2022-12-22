package com.jpa.board.controller.board;

import com.jpa.board.service.board.BoardViewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board/view")
@Log4j2
public class BoardViewController {

    @Autowired
    private BoardViewService boardViewService;

    @GetMapping
    public void getBoardView(
            @RequestParam("bidx") Long bidx,
            @RequestParam("p") int pageNum,
            Model model,
            HttpServletRequest request
    ){

        HttpSession session = request.getSession();

        if (session.getAttribute("viewEnter") != bidx){
            session.setAttribute("viewEnter", bidx);
        }

        log.info("session viewEnter 상태 ========> " +  session.getAttribute("viewEnter"));

        if (session.getAttribute("viewEnter") == bidx){
            log.info("viewEnter 진입....................");
            session.setAttribute("viewEnter", bidx);
            log.info("viewEnter 진입 후 session viewEnter 상태 ========> " +  session.getAttribute("viewEnter"));
            boardViewService.updateRcnt(bidx);

        }

        log.info("loginInfo 세션 확인 ................. ==> " + session.getAttribute("loginInfo"));

        model.addAttribute("pageNum", pageNum);
        model.addAttribute("boardView", boardViewService.selectBoard(bidx));

    }

}
