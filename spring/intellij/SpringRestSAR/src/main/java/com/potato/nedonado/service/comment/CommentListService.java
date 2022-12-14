package com.potato.nedonado.service.comment;

import com.potato.nedonado.mapper.CommentMapper;
import com.potato.nedonado.model.comment.CommentDTO;
import com.potato.nedonado.model.comment.CommentViewInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentListService {

    @Autowired
    private CommentMapper commentMapper;

    public List<CommentDTO> selectAllComments(long boardIdx){
        return commentMapper.selectCommentByBoardIdx(boardIdx);
    }

    public List<CommentViewInfo> selectBoardComment(long boardIdx, long lastIdx){

        List<CommentDTO> entities = commentMapper.selectCommentByLastCommentIdx(boardIdx, lastIdx);

        List<CommentViewInfo> list = new ArrayList<>();

        for (CommentDTO comment : entities){
            list.add(comment.toCommentView());
        }
        return list;
    }

    public List<CommentViewInfo> selectBoardCommentLimit(long boardIdx, long lastIdx){

        List<CommentDTO> entities = commentMapper.selectCommentByLastCommentIdxLimit(boardIdx, lastIdx);

        List<CommentViewInfo> list = new ArrayList<>();

        for (CommentDTO comment : entities){
            list.add(comment.toCommentView());
        }
        return list;
    }
}
