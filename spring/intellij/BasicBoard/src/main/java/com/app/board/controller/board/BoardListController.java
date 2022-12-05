package com.app.board.controller.board;

import com.app.board.domain.BoardListDTO;
import com.app.board.service.board.BoardListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
public class BoardListController {

    @Autowired
    private BoardListService boardListService;

    @GetMapping("/board/list")
    public void getBoardList(
            @RequestParam(value = "p", defaultValue = "1") int p,
            Model model
    ){

        BoardListDTO boardListDTO = boardListService.getBoardList(p);

        log.info(boardListDTO);

        model.addAttribute("page", boardListDTO);


    }

}