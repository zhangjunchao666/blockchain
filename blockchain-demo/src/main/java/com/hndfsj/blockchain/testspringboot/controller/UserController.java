package com.hndfsj.blockchain.testspringboot.controller;

import com.alibaba.fastjson.JSON;
import com.hndfsj.blockchain.testspringboot.bean.User;
import com.hndfsj.blockchain.testspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <pre>
 * TODO：
 * </pre>
 *
 * @author zhangjunchao
 * @date 2019/12/4
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("findAllUser")
    @ResponseBody
    public String findAllUser(){
        List<User> allUser = userService.findAllUser();
        return JSON.toJSONString(allUser);
    }

    @GetMapping("selectName")
    @ResponseBody
    public User selectName(){
        return userService.selectName();
    }







}
