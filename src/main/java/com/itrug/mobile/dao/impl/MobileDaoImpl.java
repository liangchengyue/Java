package com.itrug.mobile.dao.impl;

import com.itrug.mobile.dao.MobileDao;
import com.itrug.mobile.model.Mobile;
import com.itrug.mobile.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/***
 * 手机的 dao 实现类
 */
public class MobileDaoImpl implements MobileDao {
    @Override
    public Mobile get(Integer id) {
        Mobile mobile=new Mobile();
        String sql="SELECT id,name,image,price,model,vendor from mobile where id=?";
        Connection connection=DataBaseUtils.getConnection();
        PreparedStatement statement=DataBaseUtils.getPreparedStatement(connection,sql,false);
        try {
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                mobile.setId(resultSet.getInt("id"));
                mobile.setImage(resultSet.getString("image"));
                mobile.setModel(resultSet.getString("model"));
                mobile.setPrice(resultSet.getDouble("price"));
                mobile.setName(resultSet.getString("name"));
                mobile.setVendor(resultSet.getString("vendor"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
        return mobile;
    }

    @Override
    public List<Mobile> findAll() {
        String sql = "SELECT id,name,image,price,model,vendor from mobile";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        List<Mobile> mobileList = new ArrayList<Mobile>();
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Mobile mobile = new Mobile();
                mobile.setId(resultSet.getInt("id"));
                mobile.setImage(resultSet.getString("image"));
                mobile.setModel(resultSet.getString("model"));
                mobile.setPrice(resultSet.getDouble("price"));
                mobile.setName(resultSet.getString("name"));
                mobile.setVendor(resultSet.getString("vendor"));
                mobileList.add(mobile);
            }
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobileList;
    }

    @Override
    public Mobile save(Mobile mobile) {
        String sql = "INSERT INTO mobile(name,image,price,model,vendor) VALUES(?,?,?,?,?)";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
        try {
            statement.setString(1,mobile.getName());
            statement.setString(2, mobile.getImage());
            statement.setDouble(3, mobile.getPrice());
            statement.setString(4, mobile.getModel());
            statement.setString(5, mobile.getVendor());
            int rows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }
        return mobile;
    }

    @Override
    public Mobile update(Mobile mobile) {
        String sql="UPDATE mobile SET name=?,image=?,price=?,model=?,vendor=? WHERE id=?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
        try {
            statement.setString(1,mobile.getName());
            statement.setString(2,mobile.getImage());
            statement.setDouble(3,mobile.getPrice());
            statement.setString(4,mobile.getModel());
            statement.setString(5,mobile.getVendor());
            statement.setInt(6,mobile.getId());
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtils.closeStatement(statement);
            DataBaseUtils.closeConnection(connection);
        }

        return mobile;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE from mobile WHERE id = ?";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, false);
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
