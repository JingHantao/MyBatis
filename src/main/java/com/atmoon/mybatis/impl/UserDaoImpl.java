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
        return this.sqlSession.selectList("UserDao.qyeryUserAll");
    }

    public void insertUser(User user) {
        this.sqlSession.insert("UserDao.insertUser");
    }

    public void deleteUserById(Integer id) {
        this.sqlSession.delete("UserDao.deleteUserById");
    }
}
