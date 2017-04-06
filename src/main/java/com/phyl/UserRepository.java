package com.phyl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by xh on 2017/4/6.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    //注解方式查询
    @Query("from User as user where user.name=:name")
    List<User> findUserByName(@Param("name") String name);

    //JPA提供的规范
    List<User> findByName(String name);
}
