package com.app.manager.service.emp;

import com.app.manager.mapper.EmpMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmpDeleteService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public int deleteEmp(int empno){

        return empMapper.deleteEmp(empno);
    }

}
