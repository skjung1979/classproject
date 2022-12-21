package com.jpa.board.controller.board;

import com.jpa.board.service.board.BoardViewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            Model model
    ){

        model.addAttribute("pageNum", pageNum);
        model.addAttribute("boardView", boardViewService.selectBoard(bidx));

    }

}
