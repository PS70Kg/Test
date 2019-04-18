package com.demo.gradledemo.service.impl;

import com.demo.gradledemo.domain.User;
import com.demo.gradledemo.mapper.UserMapper;
import com.demo.gradledemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    //UserDao userDao;

    @Override
    public long count() {
        //long totalSize = userMapper.count();
        long totalSize = userMapper.count();
        return totalSize;
    }

    @Override
    public List<User> searchAllLimit(int pageNumber, int pageSize, String search) {
        int beginIndex = (pageNumber - 1) * pageSize;
        List<User> users = userMapper.selectAll(beginIndex, pageSize, search);
        return users;
    }

    @Override
    public int addOne(User user) {
        int result = 0;
        result = userMapper.insertOne(user);
        return result;
    }

    @Override
    public int editOne(User user) {
        int result = 0;
        result = userMapper.updateOne(user);
        return result;
    }

    @Override
    public int deleteById(int id) {
        int result = 0;
        result = userMapper.deleteOne(id);
        return result;
    }
}
