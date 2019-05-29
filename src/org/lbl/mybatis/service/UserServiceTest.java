package org.lbl.mybatis.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.lbl.mybatis.beans.User;
import org.lbl.mybatis.mapper.UserMapper;
import org.lbl.mybatis.utils.DBUtils;

import java.util.ArrayList;
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
    //批量添加操作
    public void insertUsers() throws Exception {
        SqlSession session = DBUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User("香蕉001", "8888", 8888.8);
        User user1 = new User("香蕉002", "8888", 8888.8);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        try {
            mapper.insertUsers(users);
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
    public void updateUser() throws Exception{
        SqlSession session = DBUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User("橘子","111",222.2);
        user.setId(1);
        try {
           int result =  mapper.updateUser(user);
            session.commit();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


    @Test
    public void updateUserSet() throws Exception{
        SqlSession session = DBUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User("橘子","111",222.2);
        user.setId(5);
        try {
            int result =  mapper.updateUserSet(user);
            session.commit();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


    @Test
    public void updateUsers(){
        SqlSession session = DBUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User("橘子111111","111",222.2);
        user.setId(1);
        User user1 = new User("橘子222222","222",222.2);
        user1.setId(2);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        try {
            int result =  mapper.updateUsers(users);
            System.out.println(result);
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


    @Test
    public void getUserByIds() throws Exception {
        SqlSession session= DBUtils.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        try {
            List<User> user=mapper.getUserByIds(ids);
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
    //删除操作
    public void deleteBatch() throws Exception {
        SqlSession session=DBUtils.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        try {
            mapper.deleteBatch(list);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
}
