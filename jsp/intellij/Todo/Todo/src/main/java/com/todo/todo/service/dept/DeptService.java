package com.todo.todo.service.dept;

import com.todo.todo.domain.dept.Dept;
import com.todo.todo.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeptService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    public List<Dept> getList() throws Exception {

        //@Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        List<Dept> list = deptMapper.selectAll();

        return list;
    }

}
