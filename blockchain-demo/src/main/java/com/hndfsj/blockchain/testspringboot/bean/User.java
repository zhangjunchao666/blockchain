package com.hndfsj.blockchain.testspringboot.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <pre>
 * TODO：
 * </pre>
 *
 * @author zhangjunchao
 * @date 2019/12/4
 */
public class User implements Serializable {

    @Column
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String age;

    public User(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
