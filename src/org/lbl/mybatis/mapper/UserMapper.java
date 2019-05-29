package org.lbl.mybatis.mapper;

import org.lbl.mybatis.beans.User;

import java.util.List;

public interface UserMapper {
    /**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(User user) throws Exception;
    /**
     * 批量新增用戶
     * @param users
     * @return
     * @throws Exception
     */
    public int insertUsers(List<User> users) throws Exception;
    /**
     * 修改用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int updateUser (User user) throws Exception;

    /**
     * 修改用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int updateUserSet (User user) throws Exception;

    /**
     * 批量修改用戶
     * @param users
     * @return
     * @throws Exception
     */
    public int updateUsers (List<User> users) throws Exception;

    /**
     * 刪除用戶
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteUser(int id) throws Exception;

    /**
     * 批量刪除用戶
     * @param ids
     * @return
     * @throws Exception
     */

    public int deleteBatch(List<Integer> ids) throws Exception;
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public User selectUserById(int id) throws Exception;
    /**
     * 查询所有的用户信息
     * @return
     * @throws Exception
     */
    public List<User> selectAllUser() throws Exception;

    /**
     * 根据Id查询用户信息
     * @return
     * @throws Exception
     */
    public List<User> getUserByIds(List<String> ids) throws Exception;

}
