package com.itrug.mobile.dao.impl;

import com.itrug.mobile.dao.OrderDao;
import com.itrug.mobile.model.Order;
import com.itrug.mobile.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Order get(Integer id) {
        Order order = new Order();
        String sql = "SELECT id,price,userid,mobileid,number,ispay,createtime from `order` WHERE id=?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
        try {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                order.setId(resultSet.getInt("id"));
                order.setCrateTime(resultSet.getTime("createtime"));
                order.setMobileId(resultSet.getInt("mobileid"));
                order.setUserId(resultSet.getInt("userid"));
                order.setPay(resultSet.getBoolean("ispay"));
                order.setNumber(resultSet.getInt("number"));
                order.setPrice(resultSet.getDouble("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<Order>();
        String sql = "SELECT id,price,userid,mobileid,number,ispay,createtime from `order`";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
        try {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setCrateTime(resultSet.getTime("createtime"));
                order.setMobileId(resultSet.getInt("mobileid"));
                order.setUserId(resultSet.getInt("userid"));
                order.setPay(resultSet.getBoolean("ispay"));
                order.setNumber(resultSet.getInt("number"));
                order.setPrice(resultSet.getDouble("price"));
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
        return orderList;
    }

    @Override
    public Order save(Order entity) {
        String sql = "INSERT INTO `order`(price,userid,mobileid,number,ispay,createtime) VALUES (?,?,?,?,?,?)";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        try {
            statement.setDouble(1, entity.getPrice());
            statement.setInt(2, entity.getUserId());
            statement.setInt(3, entity.getMobileId());
            statement.setInt(4, entity.getNumber());
            statement.setBoolean(5, entity.isPay());
            statement.setDate(6, new java.sql.Date(entity.getCrateTime().getTime()));
            int rows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
        return entity;
    }

    @Override
    public Order update(Order entity) {
        String sql = "UPDATE `order`SET userid=?,mobileid=?,price=?,number=?,ispay=? where id=?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
        try {
            statement.setInt(1, entity.getUserId());
            statement.setInt(2, entity.getMobileId());
            statement.setDouble(3, entity.getPrice());
            statement.setInt(4, entity.getNumber());
            statement.setBoolean(5, entity.isPay());
            statement.setInt(6, entity.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
        return entity;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE from `order` WHERE id = ?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
        try {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
    }
}
