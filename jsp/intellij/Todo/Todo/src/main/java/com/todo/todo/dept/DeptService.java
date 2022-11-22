package com.todo.todo.dept;

import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class DeptService {

    private final Dao dao;

    public DeptService(Dao dao) {
        this.dao = dao;
    }

    public List<Dept> getList() throws Exception {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        List<Dept> list = dao.selectAll(conn);

        return list;
    }

}
