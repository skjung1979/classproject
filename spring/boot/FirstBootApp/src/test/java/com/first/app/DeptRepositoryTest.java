package com.first.app;

import com.first.app.entity.Dept;
import com.first.app.entity.DeptRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        // 정렬 기준 설정
        Sort sort = Sort.by(Sort.Direction.DESC, "dname");
        List<Dept> list2 = deptRepository.findAll(sort);

        for (Dept dept : list2){
            log.info("dept.... ==> " + dept);
        }

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        // 검색
        Optional<Dept> dept1 = deptRepository.findById(10); // where deptno = ?
        Dept deptData = dept1.orElse(null);

        log.info("dept1.orElse Dept .................==> " + deptData);

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        List<Integer> nos = Arrays.asList(10, 20, 30);
        List<Dept> list3 = deptRepository.findAllById(nos);// where deptno in ?, ?, ?

        for (Dept dept : list3){
            log.info("dept.... ==> " + dept);
        }

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        // insert
        Dept insertData = Dept.builder().dname("기획팀").loc("서울").build();

        log.info("insert 전 데이터 ................. ==> " + insertData);

//        Dept resultData = deptRepository.save(insertData);

        // 인터스 후의 deptno를 자동으로 엔티티에 반환해준다.!!!!!
//        log.info("insert 후 데이터 ................. ==> " + resultData);

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        // update => save() 이용
        Dept editData = Dept.builder().deptno(201).dname("SQ").loc("분당").build();

        Dept editResult = deptRepository.save(editData);

        log.info("editResult................ ==> " + editResult);

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        // delete
       // deptRepository.deleteById(202); // dept 엔티티에서 지정한 @id의 컬럼 값

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        // 개수
        long cnt = deptRepository.count();
        log.info("전체 부서수(cnt)............... ==> " + cnt);




    }

    @Test
    public void JpqlMethodTest(){

        Dept dept1 = deptRepository.findByDeptno(30); // DeptResposity 인터페이스에 있는 메소드를 호출 가능하다!

        log.info(">>>>>>>>>>>>>>>>>  " + dept1);

        log.info(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        List list1 = deptRepository.findByDnameLikeOrderByLocAsc("%A%");

        log.info(">>>>>>>>>>>>>>> " + list1);

        log.info(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        List list2 = deptRepository.findByLocLike("%O%");

        log.info(">>>>>>>>>>>>>>> " + list2);

        log.info(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        List list3 = deptRepository.findByDeptnoBetween(30,60);

        log.info(">>>>>>>>>>>>>>> " + list3);

        log.info(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");



    }

}

























