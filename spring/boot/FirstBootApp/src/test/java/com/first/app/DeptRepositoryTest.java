package com.first.app;

import com.first.app.entity.Dept;
import com.first.app.entity.DeptRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class DeptRepositoryTest {

    @Autowired
    private DeptRepository deptRepository;

    @Test
    public void jpaMethodTest(){

        // 전체 리스트 반환 => findAll()
        List<Dept> list1 = deptRepository.findAll(); // findAll()은 리스트로 반환한다.

        for (Dept dept : list1){
            log.info("dept.... ==> " + dept);
        }

    }
}
