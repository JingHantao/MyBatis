package com.atmoon.mybatis.dao;

import com.atmoon.mybatis.bean.User;
import com.atmoon.mybatis.impl.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @auther: asuspc
 * @Date: 2018/12/23 10:48
 * @Description:
 */
public class UserDaoTest {

    public UserDao userDao;
    public SqlSession sqlSession;

    @org.junit.Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        this.userDao = new UserDaoImpl(sqlSession);
    }

    @org.junit.Test
    public void queryUserById() {
        System.out.println(this.userDao.queryUserById(1));
    }

    @org.junit.Test
    public void qyeryUserAll() {
        List<User> userList=this.userDao.qyeryUserAll();
        for(User user:userList){
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void insertUser() {
        User user =new User();
        user.setAge(21);
        user.setBirthday(new Date("1997/06/07"));
        user.setName("JingHantao");
        user.setPassword("123456");
        user.setSex(1);
        user.setUserName("jht");
        this.userDao.insertUser(user);
        this.sqlSession.commit();
    }

    @org.junit.Test
    public void updateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("HanTao");
        user.setPassword("654321");
        user.setSex(1);
        user.setUserName("ht");
        user.setId(1);
        this.userDao.updateUser(user);
        this.sqlSession.commit();

    }

    @org.junit.Test
    public void deleteUserById() {
        this.userDao.deleteUserById(4);
        this.sqlSession.commit();
    }
}