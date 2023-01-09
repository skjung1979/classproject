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
import java.util.ArrayList;

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
    ) {

        HttpSession session = request.getSession();

        ArrayList<Long> viewList = null;

        // 조회수 증가 새로운 방식 시작 ==> 실패
/*        if (session.getAttribute("viewEnter") != null){

            viewList = (ArrayList) session.getAttribute("viewEnter");

            log.info("세션의 viewEnter 가져옴....==> " + viewList);

            if (!viewList.contains(bidx)){
                log.info("!viewList.contains(bidx)... ==> " + !viewList.contains(bidx));
                boardViewService.updateRcnt(bidx);
                viewList.add(bidx);
                session.setAttribute("viewEnter", viewList.toArray());
                log.info("조회수 증가시키고 viewEnter세션에 viewlist 넣음.... => " + session.getAttribute("viewEnter"));
            }

//            viewList.add(session.getAttribute("viewEnter"));
        } else {

            boardViewService.updateRcnt(bidx);

            session.setAttribute("viewEnter", bidx);
            log.info("조회수 증가시키고 viewEnter세션에 viewlist 넣음.... => " + session.getAttribute("viewEnter"));
        }*/
        // 조회수 증가 새로운 방식 끝

        // 조회수 증가 기존 방식 시작 -> 중복 방지가 안된다
        if (session.getAttribute("viewEnter") != bidx) {
            session.setAttribute("viewEnter", bidx);
        }

        log.info("session viewEnter 상태 ========> " + session.getAttribute("viewEnter"));

        if (session.getAttribute("viewEnter") == bidx) {

            log.info("viewEnter 진입....................");
            session.setAttribute("viewEnter", bidx);
            log.info("viewEnter 진입 후 session viewEnter 상태 ========> " + session.getAttribute("viewEnter"));
            boardViewService.updateRcnt(bidx);

        }

        log.info("loginInfo 세션 확인 ................. ==> " + session.getAttribute("loginInfo"));
        // 조회수 증가 기존 방식 끝

        model.addAttribute("pageNum", pageNum);
        model.addAttribute("boardView", boardViewService.selectBoard(bidx));

    }

}
