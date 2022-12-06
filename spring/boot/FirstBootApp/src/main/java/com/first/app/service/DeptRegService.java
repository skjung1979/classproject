package com.first.app.service;

import com.first.app.domain.DeptDTO;
import com.first.app.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptRegService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    public int insertDept(DeptDTO deptDTO){

        return deptMapper.insertDept(deptDTO);
    }

//    트랜젝션 테스트 연출
    @Transactional // 해당 메소드의 내용들이 모두 정상으로 실행 되어야 적용을 시킨다.
    public int insertDepts(DeptDTO deptDTO){

        deptMapper.insertDept(deptDTO); // 성공
        deptMapper.insertDept(new DeptDTO(10, "test", "test")); // 실패
        // 이 2개가 성공해서 모두 정상 처리되는 것으로 하려함
        
        return 0;
    }

}
