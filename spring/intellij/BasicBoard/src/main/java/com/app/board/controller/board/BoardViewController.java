package com.app.board.controller.board;

import com.app.board.domain.BoardDTO;
import com.app.board.service.board.BoardViewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
public class BoardViewController {

    @Autowired
    private BoardViewService boardViewService;

    @GetMapping("/board/view")
    public void getBoardArticle(
            @RequestParam(value = "bno", defaultValue = "1") int bno,
            Model model
    ){

        BoardDTO boardDTO = boardViewService.readArticle(bno);

        log.info(boardDTO);

        model.addAttribute("board", boardDTO);

    }

}