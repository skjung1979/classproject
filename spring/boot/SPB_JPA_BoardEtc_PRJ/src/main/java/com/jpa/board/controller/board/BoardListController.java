package com.jpa.board.controller.board;

import com.jpa.board.service.board.BoardListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board/list")
@Log4j2
public class BoardListController {

    @Autowired
    private BoardListService boardListService;

    @GetMapping
    public void getBoardList(
            @RequestParam(value = "p", defaultValue = "1") int pageNum,
            Model model
    ){

        model.addAttribute("listPage", boardListService.getPageList(pageNum));

    }

}
