package com.demo.gradledemo.service;

import com.demo.gradledemo.domain.User;

import java.util.List;

public interface UserService {

    public long count();

    public List<User> searchAllLimit(int pageNumber, int pageSize, String search);

    public int addOne(User user);

    public int editOne(User user);

    public int deleteById(int id);

}
