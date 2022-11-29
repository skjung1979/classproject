package com.app.manager.controller.rest;

import com.app.manager.domain.dept.DeptDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Log4j2
public class ExampleRestController {
    // @RestController 적용 테스트
    // 클래스 선언부에 @RestController로 표시하면 Rest 스타일로 인지하고 기본적으로 return을 @ResposeBody와 같이 출력한다.
    
    // 메소드의 반환타입이 String -> 문자열 응답
    @GetMapping("/sample1")
    public String sayHello(){
        return "Hello!!";
    }

    // 객체의 반환은 JSON 형식으로 응답된다.
    @GetMapping("/sample2")
    public DeptDTO getDept(){
        DeptDTO deptDTO = DeptDTO.builder()
                .deptno(90)
                .dname("DEV")
                .loc("SEOUL")
                .build();

        return deptDTO;
    }

    @GetMapping("/sample3")
    public List<DeptDTO> getDeptList(){

        List<DeptDTO> list = new ArrayList<>();
        list.add(new DeptDTO(10, "test10", "LOC10"));
        list.add(new DeptDTO(20, "test20", "LOC20"));
        list.add(new DeptDTO(30, "test30", "LOC30"));
        list.add(new DeptDTO(40, "test40", "LOC40"));

        return list;
    }

    @GetMapping("/sample4")
    public Map<Integer, DeptDTO> getDeptMap(){

        Map<Integer, DeptDTO> map = new HashMap<>();
        map.put(10, new DeptDTO(10, "test10", "loc10"));
        map.put(20, new DeptDTO(20, "test20", "loc20"));
        map.put(30, new DeptDTO(30, "test30", "loc30"));
        map.put(40, new DeptDTO(40, "test40", "loc40"));
        map.put(50, new DeptDTO(50, "test50", "loc50"));

        return map;
    }

}
