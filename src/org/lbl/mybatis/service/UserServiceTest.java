package org.lbl.mybatis.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.lbl.mybatis.beans.User;
import org.lbl.mybatis.mapper.UserMapper;
import org.lbl.mybatis.utils.DBUtils;

import java.util.List;

public class UserServiceTest {
    @Test
    //添加操作
    public void insertUser() throws Exception {
        SqlSession session = DBUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User("香蕉", "8888", 8888.8);
        try {
            mapper.insertUser(user);
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    @Test
    //删除操作
    public void deleteUser() throws Exception {
        SqlSession session=DBUtils.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(1);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    @Test
    //选择操作
    public void selectUserById() throws Exception {
        SqlSession session=DBUtils.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            //这里用到User类的无参构造方法创建对象，User user=new User（）；
            User user =mapper.selectUserById(2);
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    @Test
    public void selectAllUser() throws Exception {
        SqlSession session= DBUtils.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            List<User> user=mapper.selectAllUser();
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

}
