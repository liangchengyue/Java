package com.itrug.mobile.service;

import com.itrug.mobile.model.User;

import java.util.List;

public interface UserService extends GenericService<User, Integer> {
    public static final String LOGIN_USER_KEY = "user";
    User findByUserName(String username);
    boolean isValidPassword(String password, String encPassword);
}
