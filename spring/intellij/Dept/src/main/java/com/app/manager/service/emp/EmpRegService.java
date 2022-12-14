package com.app.manager.service.emp;

import com.app.manager.domain.emp.EmpDTO;
import com.app.manager.mapper.EmpMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class EmpRegService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public int insertEmp(EmpDTO empDTO){
        return empMapper.insertEmp(empDTO);
    }

    public int selectMaxEmpno(){
        return empMapper.selectMaxEmpno();
    }

    public List<String> selectJob() {
        return empMapper.selectJob();
    }

    public List<EmpDTO> selectMgr() {
        return empMapper.selectMgr();
    }
}
