package com.itrug.mobile.dao.impl;

import com.itrug.mobile.dao.UserDao;
import com.itrug.mobile.model.User;
import com.itrug.mobile.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public User get(Integer id) {
        User user=new User();
        String sql="SELECT id,nickname,username,age," +
                "sex,isadmin FROM `user` WHERE id=?";
        Connection connection=DataBaseUtils.getConnection();
        PreparedStatement statement=DataBaseUtils.getPreparedStatement(connection,sql,false);
        try {
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setAdmin(resultSet.getBoolean("isadmin"));
                user.setAge(resultSet.getInt("age"));
                user.setNickName(resultSet.getString("nickname"));
                user.setSex(resultSet.getBoolean("sex"));
                user.setUsername(resultSet.getString("username"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        String sql = "INSERT INTO t_users(username,password) VALUES(?,?)";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        try {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            int rows = statement.executeUpdate();
            //获取自增主键
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(Integer s) {

    }

    @Override
    public User findByUserName(String username) {
        String sql = "SELECT id,username,password FROM t_users tu WHERE tu.username = ?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
        User user = null;
        try {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
