package com.firstcoding.mvc.springmvc;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class IndexController {

    @RequestMapping("/index")
    public void getIndex(){ // 얘는 view 이름을 반환 해야한다. void인 경우 위 요청값으로 반환한다. 그러면 index를 /WEB-INF/views/index.jsp를 반환한다.
        log.info("Index page 진입");
    }
}
