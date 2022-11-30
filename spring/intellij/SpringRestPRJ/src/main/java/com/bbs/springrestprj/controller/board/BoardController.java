package com.bbs.springrestprj.controller.board;

import com.bbs.springrestprj.domain.board.BoardDTO;
import com.bbs.springrestprj.service.board.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/boards")
public class BoardController {

    @Autowired(required = false)
    private BoardService boardService;

    @GetMapping("/all")
    public ResponseEntity<List<BoardDTO>> listBoards(){

        log.info("listBoards 메소드 호출...");

        List<BoardDTO> list = new ArrayList<>();

        list = boardService.listBoards();

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> listOneBoard(
            @PathVariable("no") Integer bno
    ){

        log.info("listOneBoard 메소드 호출...");

        BoardDTO boardDTO = boardService.listOneBoard(bno);

        return new ResponseEntity(boardDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addBoard(
            @RequestBody BoardDTO boardDTO
    ){

        log.info("addBoard 메소드 호출...");
        log.info("boardDTO. toString() => " + boardDTO.toString());

        // Header 정의
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header", "some-value");

        ResponseEntity<String> responseEntity = null;

        try{

            responseEntity = new ResponseEntity(boardService.addBoard(boardDTO), HttpStatus.OK);

        } catch (Exception e){

            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @PutMapping("/{no}")
    public HttpEntity<String> editBoard(
            @PathVariable("no") Integer bno,
            @RequestBody BoardDTO boardDTO
    ){

        log.info("modBoard 메소드 진입...");
        log.info(bno);
        log.info(boardDTO.toString());

        // Header 정의
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header", "some-value");

        return new HttpEntity<String>("update OK", httpHeaders);
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<String> removeBoard(
            @PathVariable("no") Integer bno
    ){

        log.info("removeBoard 메소드 호출....");
        log.info("bno => " + bno);

        ResponseEntity<String> responseEntity = null;

        try{

            responseEntity = new ResponseEntity(boardService.removeBoard(bno), HttpStatus.OK);

        } catch (Exception e){

            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

}
