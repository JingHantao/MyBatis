package com.atmoon.mybatis.impl;

import com.atmoon.mybatis.bean.User;
import com.atmoon.mybatis.dao.UserDao;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author asuspc
 * @auther: asuspc
 * @Date: 2018/12/22 22:05
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User queryUserById(Integer id) {
        return this.sqlSession.selectOne("UserDao.queryUserById",id);
    }

    public List<User> qyeryUserAll() {
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    public void insertUser(User user) {
        this.sqlSession.insert("UserDao.insertUser",user);
    }

    public void updateUser(User user) {
        this.sqlSession.update("UserDao.updateUser",user);
    }

    public void deleteUserById(Integer id) {
        this.sqlSession.delete("UserDao.deleteUserById",id);
    }
}
