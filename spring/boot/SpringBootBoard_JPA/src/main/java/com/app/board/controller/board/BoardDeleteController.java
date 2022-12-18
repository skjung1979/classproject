package com.app.board.controller.board;

import com.app.board.service.board.BoardDeleteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class BoardDeleteController {

    @Autowired
    private BoardDeleteService boardDeleteService;

    @GetMapping("/board/delete")
    public String delete(
            @RequestParam("bno") int bno
    ){

        boardDeleteService.delete(bno);

        return "redirect:/board/list";
    }

}
