package com.demo.gradledemo.controller;

import com.demo.gradledemo.domain.User;
import com.demo.gradledemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/addOne")
    public int addOne(User user) {
        return userService.addOne(user);
    }

    @RequestMapping("/editOne")
    public int editOne(User user) {
        return userService.editOne(user);
    }

    @RequestMapping("/deleteOne")
    public int deleteOne(@RequestParam("id") int id) {
        return userService.deleteById(id);
    }

    @RequestMapping("/showAllLimit")
    public Map showAllLimit(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize, @RequestParam("search") String search) {
        Map<String, Object> map = new HashMap();
        List<User> users = userService.searchAllLimit(pageNumber, pageSize, search);
        long totalSize = userService.count();
        map.put("rows", users);
        map.put("total", totalSize);
        return map;
    }

}
