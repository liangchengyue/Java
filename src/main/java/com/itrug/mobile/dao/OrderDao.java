package com.itrug.mobile.dao;

import com.itrug.mobile.model.Order;

import java.util.List;

/***
 * 订单的 Dao
 */
public interface OrderDao extends GenericDao<Order,Integer> {
    List<Order> findOrderByUserId(int userid);
}
