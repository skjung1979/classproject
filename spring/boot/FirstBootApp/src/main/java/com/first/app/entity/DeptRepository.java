package com.first.app.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

// 어노테이션 할 필요 없고, 주입만 받으면 된다.
public interface DeptRepository extends JpaRepository<Dept, Integer> {

    Dept findByDeptno(Integer deptno);

    List<Dept> findByDnameLikeOrderByLocAsc(@NonNull String dname);

    List<Dept> findByDeptnoGreaterThanAndDnameLikeAndLoc(Integer deptno, String dname, String loc);

    @Query("select d from Dept d where d.loc like :loc")
    List<Dept> findByLocLike(@Param("loc") String loc);

    @Query("select d from Dept d where d.deptno between :sss and :eee")
    List<Dept> findByDeptnoBetween(@Param("sss") Integer deptnoStart, @Param("eee") Integer deptnoEnd);




}
