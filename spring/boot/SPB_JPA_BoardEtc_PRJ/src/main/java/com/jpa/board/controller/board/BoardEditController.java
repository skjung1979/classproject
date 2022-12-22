package com.jpa.board.controller.board;

import com.jpa.board.domain.BoardEditRequest;
import com.jpa.board.entity.board.Board;
import com.jpa.board.service.board.BoardEditService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/edit")
@Log4j2
public class BoardEditController {

    @Autowired
    private BoardEditService boardEditService;

    @GetMapping
    public void getBoardEdit(
            @RequestParam("bidx") Long bidx,
            @RequestParam("p") int pageNum,
            Model model
    ){

        model.addAttribute("pageNum", pageNum);

        Board board = boardEditService.boardEditView(bidx);

        log.info("board............................ ==> " + board);

        model.addAttribute("boardEditView", board);

    }

    @PostMapping
    public String postBoardEdit(
            BoardEditRequest boardEditRequest,
            RedirectAttributes redirectAttributes
    ){

        log.info("boardEditRequest.................... ==> " + boardEditRequest);

        redirectAttributes.addAttribute("bidx", boardEditRequest.getBidx());
        redirectAttributes.addAttribute("p", boardEditRequest.getP());

        boardEditService.boardEdit(boardEditRequest);

        return "redirect:/board/view";
    }

}
