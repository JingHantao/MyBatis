package com.atmoon.mybatis.dao;

import com.atmoon.mybatis.bean.User;

import java.util.List;

/**
 * @auther: asuspc
 * @Date: 2018/12/22 21:58
 * @Description:
 */
public interface UserDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User queryUserById(Integer id);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> qyeryUserAll();

    /**
     * 增加用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    public void deleteUserById(Integer id);
}
