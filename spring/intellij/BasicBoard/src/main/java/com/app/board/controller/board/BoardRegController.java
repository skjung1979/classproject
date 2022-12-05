package com.app.board.controller.board;


import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardRegRequestDTO;
import com.app.board.service.board.BoardRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/board/reg")
public class BoardRegController {

    @Autowired
    private BoardRegService boardRegService;

    @GetMapping
    public void getRegForm(){
    }

    @PostMapping
    public String reg(
            BoardRegRequestDTO boardRegRequestDTO
    ){

        log.info(boardRegRequestDTO);

        boardRegService.regBoardContent(boardRegRequestDTO);

        return "redirect:/board/list";
    }

}