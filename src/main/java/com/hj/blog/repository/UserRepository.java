package com.hj.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hj.blog.model.User;

// @Repository // 생략가능
public interface UserRepository extends JpaRepository<User, Integer>{

}
