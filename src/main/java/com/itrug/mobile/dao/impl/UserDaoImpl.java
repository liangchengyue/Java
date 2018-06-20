package com.itrug.mobile.dao.impl;

import com.itrug.mobile.dao.UserDao;
import com.itrug.mobile.model.User;
import com.itrug.mobile.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    /**
     * 通过ID获取用户信息
     * @param id
     * @return
     */
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
                user.setNickname(resultSet.getString("nickname"));
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
        List<User> userList=new ArrayList<User>();

        String sql="SELECT id,nickname,username,age,sex,isadmin FROM `user`";
        Connection connection=DataBaseUtils.getConnection();
        PreparedStatement statement=DataBaseUtils.getPreparedStatement(connection,sql,false);
        try {
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setAdmin(resultSet.getBoolean("isadmin"));
                user.setAge(resultSet.getInt("age"));
                user.setNickname(resultSet.getString("nickname"));
                user.setSex(resultSet.getBoolean("sex"));
                user.setUsername(resultSet.getString("username"));
                userList.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
        return userList;
    }

    @Override
    public User save(User user) {
        String sql = "INSERT INTO `user`(nickname,password,username,age,sex,isadmin) VALUES(?,?,?,?,?,?)";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
        try {
            statement.setString(1, user.getNickname());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getUsername());
            statement.setInt(4, user.getAge());
            statement.setBoolean(5, user.isSex());
            statement.setBoolean(6, user.isAdmin());
            statement.executeUpdate();
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
        String sql="UPDATE `user` SET nickname=?,password=?,username=?,age=?,sex=?,isadmin=? where id=?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
        try {
            statement.setString(1, user.getNickname());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getUsername());
            statement.setInt(4, user.getAge());
            statement.setBoolean(5, user.isSex());
            statement.setBoolean(6, user.isAdmin());
            statement.setInt(7,user.getId());
            statement.executeUpdate();
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        String sql="DELETE FROM `user` WHERE id=?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
        User user = null;
        try {
            statement.setInt(1, id);
            statement.execute();
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByUserName(String username) {
        String sql = "SELECT id,nickname,username,age,sex,isadmin FROM `user` tu WHERE tu.username = ?";
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

    @Override
    public User login(User user) {
        String sql = "SELECT id,nickname,username,age,sex,isadmin FROM `user` tu WHERE tu.username = ? and tu.password=? and isadmin=?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
        try {
            statement.setString(1, user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setBoolean(3,user.isAdmin());
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
