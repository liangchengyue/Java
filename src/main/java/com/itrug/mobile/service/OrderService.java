package com.itrug.mobile.service;

import com.itrug.mobile.model.Order;

import java.util.List;

public interface OrderService extends GenericService<Order,Integer> {
    List<Order> findOrderByUserId(int userid);
}
