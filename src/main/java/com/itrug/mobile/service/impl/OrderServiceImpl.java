package com.itrug.mobile.service.impl;

import com.itrug.mobile.dao.OrderDao;
import com.itrug.mobile.dao.UserDao;
import com.itrug.mobile.dao.impl.OrderDaoImpl;
import com.itrug.mobile.dao.impl.UserDaoImpl;
import com.itrug.mobile.model.Order;
import com.itrug.mobile.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao=new OrderDaoImpl();
    @Override
    public Order get(Integer id) {
        return orderDao.get(id);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public Order save(Order entity) {
        return orderDao.save(entity);
    }

    @Override
    public Order update(Order entity) {
        return orderDao.update(entity);
    }

    @Override
    public void delete(Integer id) {
        orderDao.delete(id);
    }
}
