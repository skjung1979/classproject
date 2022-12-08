package com.potato.nedonado.controller.board;

import com.potato.nedonado.service.board.ItemUpdateService;
import com.potato.nedonado.service.board.ItemViewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/app/v1/item")
public class ItemRestController {

    @Autowired
    private ItemViewService itemViewService;

    @Autowired
    private ItemUpdateService itemUpdateService;

}
