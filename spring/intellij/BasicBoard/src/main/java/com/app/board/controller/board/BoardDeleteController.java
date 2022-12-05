package com.app.board.controller.board;

import com.app.board.service.board.BoardDeleteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
public class BoardDeleteController {

    @Autowired
    private BoardDeleteService boardDeleteService;

    @GetMapping("/board/delete")
    public String getBoardArticle(
            @RequestParam(value = "bno") int bno,
            Model model
    ){

        log.info("삭제 할 bno ==>  "+bno);

        boardDeleteService.deleteArticle(bno);

        return "redirect:/board/list";
    }

}