package com.potato.nedonado.controller.board;

import com.potato.nedonado.model.board.ItemEntity;
import com.potato.nedonado.model.board.ItemViewListInfo;
import com.potato.nedonado.model.user.LoginInfo;
import com.potato.nedonado.service.board.*;
import com.potato.nedonado.service.comment.CommentDeleteService;
import com.potato.nedonado.service.comment.CommentListService;
import com.potato.nedonado.util.CategoryUtil;
import com.potato.nedonado.util.Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequestMapping("/app/v1/item")
public class ItemRestController {

    @Autowired
    private ItemViewService itemViewService;

    @Autowired
    private ItemUpdateService itemUpdateService;

    @Autowired
    private ItemWriteService itemWriteService;

    @Autowired
    private ItemDeleteService itemDeleteService;

    @Autowired
    private ItemListService itemListService;

    @Autowired
    private CommentListService commentListService;

    @Autowired
    private CommentDeleteService commentDeleteService;

    @GetMapping("/list")
    public ModelAndView getBoardList(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("itemList", itemListService.selectBoardListByPage(0));
        mav.setViewName("/board/itemlist");
        return mav;
    }

    public ResponseEntity<List<ItemViewListInfo>> getBoardList(
            @PathVariable("idx") long boardIdx
    ){
        List<ItemViewListInfo> itemList = itemListService.selectBoardListByListIdx(boardIdx);

        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(itemList, httpHeaders, HttpStatus.OK);
    }

    @GetMapping
    public ModelAndView writeItemViewPage(
            HttpServletRequest request
    ){
        ModelAndView mav = new ModelAndView();
        mav.clear();
        mav.addObject("itemCategory", CategoryUtil.categoryNames);
        mav.setViewName("/board/itemwrite");
        return mav;
    }

    @GetMapping("/{idx}")
    public ModelAndView viewItem(
            @PathVariable("idx") long boardIdx,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ModelAndView mav = new ModelAndView();
        mav.clear();
        mav.addObject("item", itemViewService.selectItemByIdx(boardIdx));
        mav.addObject("commentList", commentListService.selectBoardCommentLimit(boardIdx, 0));
        mav.setViewName("/board/itemview");
        return mav;
    }

    @GetMapping("/{idx}/{userIdx}")
    public ModelAndView updateItemPage(
            @PathVariable("idx") long boardIdx,
            @PathVariable("userIdx") long userIdx,
            HttpServletRequest request
    ){
        ModelAndView mav = new ModelAndView();
        mav.clear();

        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute("loginInfo");
        if (loginInfo == null || userIdx != loginInfo.getUserIdx()){
            mav.setViewName("/login");
            return mav;
        }

        ItemEntity itemEntity = itemViewService.selectItemByIdxAndUserIdx(boardIdx, userIdx);
        if (itemEntity == null){
            mav.setViewName("/login");
            return mav;
        }

        mav.addObject("itemCategory", CategoryUtil.categoryNames);
        mav.addObject("item", itemEntity);
        mav.setViewName("/board/itemUpdate");
        return mav;
    }

    @PostMapping("/{idx}")
    public ResponseEntity<Map<String, String>> updateItem(
            HttpServletRequest request,
            @PathVariable("idx") long boardIdx,
            @RequestBody ItemEntity itemEntity
    ){
        log.info(itemEntity);

        HttpHeaders httpHeaders = new HttpHeaders();
        Map<String, String> result = new HashMap<>();

        if ((itemEntity.getTitle() == null || itemEntity.getTitle().isEmpty()) || (itemEntity.getContent() == null || itemEntity.getContent().isEmpty()) || (itemEntity.getPrice() <= 0)){
            result.put("msg", "입력 데이터를 다시 확인해주세요.");
            return new ResponseEntity<>(result, httpHeaders, HttpStatus.OK);
        }

        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute("loginInfo");
        if (loginInfo == null){
            result.put("msg", "세션이 만료되었습니다.");
            result.put("url", "/login");
            return new ResponseEntity<>(result, httpHeaders, HttpStatus.OK);
        }
        log.info(loginInfo);

        itemEntity.setUserIdx(loginInfo.getUserIdx());
        log.info(itemEntity);
        int r = itemUpdateService.updateItemByitemEntity(itemEntity);

        result.put("url", "/board/view/"+itemEntity.getBoardIdx());
        return new ResponseEntity<>(result, httpHeaders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> writeItem(
            HttpServletRequest request,
            @RequestBody ItemEntity itemEntity
    ){
        log.info(itemEntity);

        HttpHeaders httpHeaders = new HttpHeaders();

        if ((itemEntity.getTitle() == null || itemEntity.getTitle().isEmpty()) || (itemEntity.getContent() == null || itemEntity.getContent().isEmpty()) || (itemEntity.getPrice() <= 0)){
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }

        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute("loginInfo");
        if (loginInfo == null){
            return new ResponseEntity<>("/login", httpHeaders, HttpStatus.BAD_REQUEST);
        }
        log.info(loginInfo);

        itemEntity.setUserIdx(loginInfo.getUserIdx());
        itemEntity.setWriteDate(Util.getCurrentTimestamp());

        log.info(itemEntity);
        int result = itemWriteService.writeItem(itemEntity);

        return new ResponseEntity<>("/app/v1/item/list", httpHeaders, HttpStatus.OK);
    }



}
