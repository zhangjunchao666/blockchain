package com.hndfsj.blockchain.testspringboot.service;

import com.hndfsj.blockchain.testspringboot.bean.User;

import java.util.List;

/**
 * <pre>
 * TODO：
 * </pre>
 *
 * @author zhangjunchao
 * @date 2019/12/4
 */
public interface UserService {


    //public void addUser(User user);

    List<User> findAllUser();

    User selectName();



}
