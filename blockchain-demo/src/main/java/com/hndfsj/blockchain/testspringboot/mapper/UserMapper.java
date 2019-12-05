package com.hndfsj.blockchain.testspringboot.mapper;

import com.hndfsj.blockchain.testspringboot.bean.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * <pre>
 * TODO：
 * </pre>
 *
 * @author zhangjunchao
 * @date 2019/12/4
 */
public interface UserMapper extends Mapper<User> {

    //@Select("select * from user")
    User selectName();



}
