package com.hndfsj.blockchain.testspringboot.service.impl;

import com.hndfsj.blockchain.testspringboot.bean.User;
import com.hndfsj.blockchain.testspringboot.mapper.UserMapper;
import com.hndfsj.blockchain.testspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <pre>
 * TODO：
 * </pre>
 *
 * @author zhangjunchao
 * @date 2019/12/4
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public User selectName() {
        return userMapper.selectName();
    }


}
