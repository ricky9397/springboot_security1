package com.ricky.security1.repository;

import com.ricky.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// CRUD 함수를 JpaRepository가 들고 있음.
// @Repository라는 어너테이션이 없어도 상송받았기때문에 가능.
public interface UserRepository extends JpaRepository<User, Integer> {

    // findBy규칙 -> Username은 문법
    // select * from user where username = 1 ?
    public User findByUsername(String username); // JPA 쿼리 메소드

}
