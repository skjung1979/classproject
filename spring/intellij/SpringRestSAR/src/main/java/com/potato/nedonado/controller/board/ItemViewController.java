package com.potato.nedonado.controller.board;

import com.potato.nedonado.service.board.ItemViewService;
import com.potato.nedonado.service.comment.CommentListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/board/view")
@Log4j2
public class ItemViewController {

    @Autowired
    private ItemViewService itemViewService;

    @Autowired
    private CommentListService commentListService;

    @GetMapping("/{idx}")
    public String viewItem(
            @PathVariable("idx") long boardIdx,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        request.setAttribute("item", itemViewService.selectItemByIdx(boardIdx));
        request.setAttribute("commentList", commentListService.selectBoardCommentLimit(boardIdx, 0));

        return "/board/itemView";
    }
}
