package com.fhh.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fhh.springboot.Entity.User1;
import com.fhh.springboot.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述：（）
 * Created by biubiubiu小浩 on 2018-09-16 15:4
 */
@RestController
public class UserController {
    @Reference(version = "1.0.0",timeout = 30000)
    private UserService userService;

    @RequestMapping(value = "/sayHi/{userName}",method = RequestMethod.GET)
    public String addUser(@PathVariable String userName){
        String hi = userService.sayHi(userName);
        return  hi;
    }

    @RequestMapping(value = "/findUser/{id}",method = RequestMethod.GET)
    public User1 findUser(@PathVariable int id){
      return userService.getUserById(id);
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<User1> findAll(){
        return userService.selectAllUser();
    }
}
