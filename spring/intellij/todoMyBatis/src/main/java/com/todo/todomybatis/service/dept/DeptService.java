package com.todo.todomybatis.service.dept;

import com.todo.todomybatis.domain.dept.Dept;
import com.todo.todomybatis.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeptService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    public List<Dept> getList() throws Exception {

        return deptMapper.selectAll();
    }

}
