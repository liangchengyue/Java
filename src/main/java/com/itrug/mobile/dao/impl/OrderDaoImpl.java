package com.itrug.mobile.dao.impl;

import com.itrug.mobile.dao.OrderDao;
import com.itrug.mobile.model.Order;
import com.itrug.mobile.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Order get(Integer id) {
        Order order=new Order();
        String sql="SELECT id,price,userid,mobileid,number,ispay,createtime from `order` WHERE id=?";
        Connection connection=DataBaseUtils.getConnection();
        PreparedStatement statement=DataBaseUtils.getPreparedStatement(connection,sql,false);
        try {
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                order.setId(resultSet.getInt("id"));
                order.setCrateTime(resultSet.getTime("createtime"));
                order.setMobileId(resultSet.getInt("mobileid"));
                order.setUserId(resultSet.getInt("userid"));
                order.setPay(resultSet.getBoolean("ispay"));
                order.setNumber(resultSet.getInt("number"));
                order.setPrice(resultSet.getDouble("price"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList=new ArrayList<Order>();
        String sql="SELECT id,price,userid,mobileid,number,ispay,createtime from `order`";
        Connection connection=DataBaseUtils.getConnection();
        PreparedStatement statement=DataBaseUtils.getPreparedStatement(connection,sql,false);
        try {
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                Order order=new Order();
                order.setId(resultSet.getInt("id"));
                order.setCrateTime(resultSet.getTime("createtime"));
                order.setMobileId(resultSet.getInt("mobileid"));
                order.setUserId(resultSet.getInt("userid"));
                order.setPay(resultSet.getBoolean("ispay"));
                order.setNumber(resultSet.getInt("number"));
                order.setPrice(resultSet.getDouble("price"));
                    orderList.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
        return orderList;
    }

    @Override
    public Order save(Order entity) {
//        String sql = "INSERT INTO model(name,image,price,model,vendor) VALUES(?,?,?,?,?)";
//        Connection connection = DataBaseUtils.getConnection();
//        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
//        try {
//            statement.setString(1,mobile.getName());
//            statement.setString(2, mobile.getImage());
//            statement.setDouble(3, mobile.getPrice());
//            statement.setString(4, mobile.getModel());
//            statement.setString(5, mobile.getVendor());
//            int rows = statement.executeUpdate();
//            //获取自增主键
//            ResultSet resultSet = statement.getGeneratedKeys();
//            if (resultSet.next()) {
//                mobile.setId(resultSet.getInt(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            DataBaseUtils.closeStatement(statement);
//            DataBaseUtils.closeConnection(connection);
//        }
        return entity;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE from order WHERE id = ?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        try {
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
    }
}
