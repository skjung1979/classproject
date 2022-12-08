package com.potato.nedonado.service.board;

import com.potato.nedonado.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ItemWriteService {

    @Autowired
    private BoardMapper boardMapper;

    public int writeItem(ItemEntity itemEntity){
        return boardMapper.insertitem(itemEntity);
    }

}
