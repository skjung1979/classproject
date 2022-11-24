package com.app.manager.mapper;

import com.app.manager.domain.EmpDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EmpMapper {
    List<EmpDTO> selectAll();

    int insertEmp(EmpDTO empDTO);

    int selectMaxEmpno();

    List<String> selectJob();

    List<EmpDTO> selectMgr();

    EmpDTO selectByEmpno(int empno);

    void updateEmpDTO(EmpDTO empDTO);

    int deleteEmp(int empno);
}
