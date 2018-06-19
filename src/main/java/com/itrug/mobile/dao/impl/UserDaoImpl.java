package com.itrug.mobile.dao.impl;

import com.itrug.mobile.dao.IUserDao;
import com.itrug.mobile.model.User;
import com.itrug.mobile.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    public void addUser(User user) {
        String sql="insert into user (id,username,password,sex,isadmin,age,nickname) values(?,?,?,?,?,?,?)";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        try {
            statement.setInt(1,user.getId());
            statement.setString(2,user.getUsername());
            statement.setString(3,user.getPassword());
            statement.setBoolean(4,user.isSex());
            statement.setBoolean(5,user.isAdmin());
            statement.setInt(6,user.getAge());
            statement.setString(7,user.getNickname());
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
    String sql="update user set username=?,password=?,sex=?,isadmin=?,age=?,nickname=? where id=?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        try {
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setBoolean(3,user.isSex());
            statement.setBoolean(4,user.isAdmin());
            statement.setInt(5,user.getAge());
            statement.setString(6,user.getNickname());
            statement.setInt(7,user.getId());
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        String sql="delete from user where id=? ";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        try {
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findUser() {
        String sql="select id,username,password,sex,isadmin,age,nickname from user";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        List<User> users=new ArrayList<User>();
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setSex(resultSet.getBoolean(4));
                user.setAdmin(resultSet.getBoolean(5));
                user.setAge(resultSet.getInt(6));
                user.setNickname(resultSet.getString(7));
                users.add(user);
            }
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User findUserById(int id) {
        String sql="select id,username,password,sex,isadmin,age,nickname from user where id=?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        List<User> users=new ArrayList<User>();
        try {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setSex(resultSet.getBoolean(4));
                user.setAdmin(resultSet.getBoolean(5));
                user.setAge(resultSet.getInt(6));
                user.setNickname(resultSet.getString(7));
                users.add(user);
            }
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users.get(0);
    }

    public User login(User user) {
    String sql="select id,username,password,sex,isadmin,age,nickname from user where username=?,password=? isadmin=?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        List<User> users=new ArrayList<User>();
        try {
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setBoolean(3,user.isAdmin());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setSex(resultSet.getBoolean(4));
                user.setAdmin(resultSet.getBoolean(5));
                user.setAge(resultSet.getInt(6));
                user.setNickname(resultSet.getString(7));
                users.add(user);
            }
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users.get(0);
    }
}
