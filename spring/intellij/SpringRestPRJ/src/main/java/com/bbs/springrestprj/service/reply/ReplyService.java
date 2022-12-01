package com.bbs.springrestprj.service.reply;

import com.bbs.springrestprj.domain.reply.ReplyDTO;
import com.bbs.springrestprj.mapper.reply.ReplyMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ReplyService {

    @Autowired(required = false)
    private ReplyMapper replyMapper;

    public List<ReplyDTO> listReplys() {

        return replyMapper.listReplys();
    }

    public ReplyDTO listOneReply(Integer bno) {

        return replyMapper.listOneReply(bno);
    }

    public int addReply(ReplyDTO boardDTO) {

        return replyMapper.addReply(boardDTO);
    }

    public int editReply(ReplyDTO replyDTO) {

        return replyMapper.editReply(replyDTO);
    }

    public int removeReply(Integer rno) {

        return replyMapper.removeReply(rno);
    }

    public int maxRno() {

        return replyMapper.maxRno();
    }

    public String membernm(int i) {

        return replyMapper.membernm(7);
    }
}
