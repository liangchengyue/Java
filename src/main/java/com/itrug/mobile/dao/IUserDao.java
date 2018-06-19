package com.itrug.mobile.dao;

import com.itrug.mobile.model.User;

import java.util.List;

public interface IUserDao {
    /**
     * 添加用户
     * @param user 用户信息
     */
    public void addUser(User user);

    /**
     * 修改用户信息
     * @param user 用户信息
     */
    public  void updateUser(User user);

    /**
     * 根据id删除用户信息
     * @param id 用户id
     */
    public void deleteUser(int id);

    /**
     * 获取所有用户信息
     * @return 所有用户信息
     */
    public List<User> findUser();

    /**
     * 根据id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    public User findUserById(int id);

    /**
     * 用户登录
     * @param user 用户信息
     */
    public User login(User user);
}
