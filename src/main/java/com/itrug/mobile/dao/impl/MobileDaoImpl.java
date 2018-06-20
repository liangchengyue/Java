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
        return null;
    }

    @Override
    public List<Mobile> findAll() {
        String sql = "select id,price,image,model,vendor from t_mobiles";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        List<Mobile> mobileList = new ArrayList<Mobile>();
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Mobile mobile = new Mobile();
                mobile.setId(resultSet.getInt(1));
                mobile.setPrice(resultSet.getDouble(2));
                mobile.setImage(resultSet.getString(3));
                mobile.setModel(resultSet.getString(4));
                mobile.setVendor(resultSet.getString(5));
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
        String sql = "INSERT INTO t_mobiles (price,image,model,vendor) VALUES(?,?,?,?)";
        Connection connection = DataBaseUtils.getConnection();
        PreparedStatement statement = DataBaseUtils.getPreparedStatement(connection, sql, true);
        try {
            statement.setDouble(1, mobile.getPrice());
            statement.setString(2, mobile.getImage());
            statement.setString(3, mobile.getModel());
            statement.setString(4, mobile.getVendor());
            int rows = statement.executeUpdate();
            //获取自增主键
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                mobile.setId(resultSet.getInt(1));
            }
            DataBaseUtils.closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobile;
    }

    @Override
    public Mobile update(Mobile mobile) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM t_mobiles WHERE id = ?";
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
}
