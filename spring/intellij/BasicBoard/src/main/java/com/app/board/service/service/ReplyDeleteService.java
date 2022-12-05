package com.app.board.service.service;

import com.app.board.domain.ReplyDTO;
import com.app.board.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyDeleteService {

    @Autowired(required = false)
    private ReplyMapper replyMapper;

    public int deleteReply(int rno){
        return replyMapper.deleteReply(rno);
    }

}