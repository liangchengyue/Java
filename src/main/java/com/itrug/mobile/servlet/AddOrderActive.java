package com.itrug.mobile.servlet;

import com.itrug.mobile.model.Mobile;
import com.itrug.mobile.model.Order;
import com.itrug.mobile.model.User;
import com.itrug.mobile.service.MobileService;
import com.itrug.mobile.service.OrderService;
import com.itrug.mobile.service.impl.MobileServiceImp;
import com.itrug.mobile.service.impl.OrderServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/addOrder")
public class AddOrderActive extends BaseAction {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        MobileService mobileService=new MobileServiceImp();
        Mobile mobile=((MobileServiceImp) mobileService).get(id);
        Order order=new Order();
        order.setCrateTime(new Date());
        order.setMobileId(id);
        order.setNumber(1);
        order.setPay(false);
        order.setPrice(mobile.getPrice());
        User user=(User)(request.getSession().getAttribute("user"));
        order.setUserId(user.getId());
        OrderService orderService=new OrderServiceImpl();
        orderService.save(order);
        response.sendRedirect("orderList");
    }
}
