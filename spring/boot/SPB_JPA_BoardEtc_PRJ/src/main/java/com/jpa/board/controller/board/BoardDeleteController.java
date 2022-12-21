package com.jpa.board.controller.board;

import com.jpa.board.repository.board.BoardRepository;
import com.jpa.board.service.board.BoardDeleteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board/delete")
@Log4j2
public class BoardDeleteController {

    @Autowired
    private BoardDeleteService boardDeleteService;

    @GetMapping
    public String delete(
            @RequestParam("bidx") Long bidx
    ){

        boardDeleteService.delete(bidx);

        return "redirect:/board/list";
    }

}
