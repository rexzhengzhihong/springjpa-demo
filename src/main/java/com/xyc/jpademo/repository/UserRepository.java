package com.xyc.jpademo.repository;

import com.xyc.jpademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor
{
    // 根据name查询用户，无需sql
    User findByUsername(@Param("username") String username);
}
