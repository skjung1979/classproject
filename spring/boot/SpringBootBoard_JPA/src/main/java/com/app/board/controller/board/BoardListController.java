package com.app.board.controller.board;

import com.app.board.service.board.BoardListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class BoardListController {

    @Autowired
    private BoardListService boardListService;


    @GetMapping("/board/list") // /board/list?p=4 이런식으로 들어온다.
    public void getList(
            @RequestParam(value = "p", defaultValue = "1") int pageNum,
            Model model

    ){

        model.addAttribute("boardList", boardListService.getList(pageNum));
        model.addAttribute("listPage", boardListService.getPage(pageNum));



    }
}
