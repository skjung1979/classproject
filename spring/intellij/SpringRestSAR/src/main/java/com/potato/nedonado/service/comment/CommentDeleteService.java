package com.potato.nedonado.service.comment;

import com.potato.nedonado.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentDeleteService {

    @Autowired
    private CommentMapper commentMapper;

    public int deleteComment(long commentIdx, long userIdx){
        return commentMapper.deleteComment(commentIdx, userIdx);
    }

    public int deleteCommentByBoardIdx(long boardIdx){
        return commentMapper.deleteCommentByBoardIdx(boardIdx);
    }
}
