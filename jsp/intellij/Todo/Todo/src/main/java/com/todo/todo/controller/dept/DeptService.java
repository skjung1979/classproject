package com.todo.todo.controller.dept;

import com.todo.todo.Dao.dept.DeptDao;
import com.todo.todo.domain.dept.Dept;
import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class DeptService {

    private final DeptDao deptDao;

    public DeptService(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    public List<Dept> getList() throws Exception {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        List<Dept> list = deptDao.selectAll(conn);

        return list;
    }

}
