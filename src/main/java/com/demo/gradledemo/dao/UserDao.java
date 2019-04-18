package com.demo.gradledemo.dao;

import com.demo.gradledemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {


}
