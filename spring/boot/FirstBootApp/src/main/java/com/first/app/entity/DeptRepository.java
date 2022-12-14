package com.first.app.entity;

import org.springframework.data.jpa.repository.JpaRepository;

// 어노테이션 할 필요 없고, 주입만 받으면 된다.
public interface DeptRepository extends JpaRepository<Dept, Integer> {
}
