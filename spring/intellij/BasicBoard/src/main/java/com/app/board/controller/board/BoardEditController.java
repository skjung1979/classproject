package com.app.board.controller.board;

import com.app.board.domain.BoardDTO;
import com.app.board.service.board.BoardEditService;
import com.app.board.service.board.BoardViewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/board/edit")
public class BoardEditController {

    @Autowired
    private BoardViewService boardViewService;

    @Autowired
    private BoardEditService boardEditService;

    @GetMapping
    public void getRegForm(
            @RequestParam("bno") int bno,
            Model model
    ){
        model.addAttribute("board", boardViewService.readArticle(bno));
    }

    @PostMapping
    public String reg(
            BoardDTO boardDTO
    ){

        log.info(boardDTO);

        boardEditService.editBoardArticle(boardDTO);

        return "redirect:/board/list";
    }

}