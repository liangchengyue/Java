package com.itrug.mobile.dao;

import com.itrug.mobile.model.User;

/***
 * 用户的 Dao
 */
public interface UserDao extends GenericDao<User, Integer> {
    /***
     * 根据 username 找该用户
     * @param username
     * @return
     */
    User findByUserName(String username);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

}
