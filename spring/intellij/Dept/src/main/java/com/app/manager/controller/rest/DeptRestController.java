package com.app.manager.controller.rest;

import com.app.manager.domain.dept.DeptDTO;
import com.app.manager.service.dept.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/v1/depts")
public class DeptRestController {

    // get => 전체 리스트
    // get/{no} => 부서 하나의 정보
    // post => Json 형식의 데이터를 받아서 입력 처리
    // put/{no} => 하나의 부서정보를 수정, 모든 데이터를 갱신한다.
    // delete/{no} => 부서 정보 하나를 삭제

    @Autowired
    private DeptListService deptListService;

    @Autowired
    private DeptReadService deptReadService;

    @Autowired
    private DeptRegService deptRegService;

    @Autowired
    private DeptEditService deptEditService;

    @Autowired
    private DeptDeleteService deptDeleteService;

    @GetMapping
    public ResponseEntity<List<DeptDTO>> getDeptList(){

        return new ResponseEntity<>(deptListService.getList(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{no}") // 요청 들어올 때 /api/vi/depts/10 이런 식으로 들어온다. 앞 JSP페이지에서 키값을 받아 올때 사용
    public DeptDTO getDept(
            @PathVariable("no") int deptno
    ){
        log.info("getDept() deptno => " + deptno);

        return deptReadService.getDept(deptno);
    }

    @PostMapping // client에서 전송하는 JSON 데이터를 받아서 처리
    public ResponseEntity<String> regDept(
            @RequestBody DeptDTO deptDTO
    ){
        log.info(deptDTO);

        deptRegService.insertDept(deptDTO);

        // Header 정의
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header", "some-value");

        // ResponseEntity<String>는 뭔가? => 바디의 응답 데이터를 제네릭으로 정의
        // 객체 생성 시 => 응답 데이터를 정의 => http header값도 설정해서 응답 가능, http status code(응답코드)도 정의해서 응답 처리 가능
        //return new ResponseEntity<>("insert OK", HttpStatus.OK);
        return new ResponseEntity<>("insert OK",httpHeaders, HttpStatus.OK);
    }

    @PutMapping("/{no}")
    public HttpEntity<String> editDept(
            @PathVariable("no") int deptno,
            @RequestBody DeptDTO deptDTO
    ){
        log.info("deptno => " + deptno);
        log.info("deptDTO => " + deptDTO);

        // Header 정의
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("some-header", "some-value");

        deptEditService.editDept(deptDTO);

        return new HttpEntity<String>("update OK", httpHeaders);
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<String> deleteDept(
            @PathVariable("no") int deptno
    ){

        log.info("delete.... / deptno => " + deptno);

        deptDeleteService.deleteDept(deptno);

        //return new ResponseEntity<String>(HttpStatus.OK); 이렇게도 가능!
        return new ResponseEntity<String>("delete OK", HttpStatus.OK);
    }
}
