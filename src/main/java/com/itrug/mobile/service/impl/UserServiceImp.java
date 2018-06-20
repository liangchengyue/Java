package com.itrug.mobile.service.impl;

import com.itrug.mobile.common.Constants;
import com.itrug.mobile.dao.UserDao;
import com.itrug.mobile.dao.impl.UserDaoImpl;
import com.itrug.mobile.model.Mobile;
import com.itrug.mobile.model.User;
import com.itrug.mobile.service.UserService;
import com.itrug.mobile.utils.BCryptPasswordEncoder;

import java.util.List;

public class UserServiceImp implements UserService {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(Constants.PASSWORD_ENCODER_ROUNDS_STRENGTH);
    UserDao userDao = new UserDaoImpl();

    @Override
    public User get(Integer id) {
        return userDao.get(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public User update(User user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userDao.update(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public boolean isValidPassword(String password, String encPassword) {
        return bCryptPasswordEncoder.matches(password, encPassword);
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }
}
