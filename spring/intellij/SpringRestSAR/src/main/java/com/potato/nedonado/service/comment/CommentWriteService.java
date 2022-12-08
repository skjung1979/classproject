package com.potato.nedonado.service.comment;

import com.potato.nedonado.mapper.CommentMapper;
import com.potato.nedonado.model.comment.CommentDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CommentWriteService {

    @Autowired
    private CommentMapper commentMapper;

    public int writeComment(CommentDTO commentDTO){

        log.info(commentDTO);
        return commentMapper.insertComment(commentDTO);
    }
}
