package com.itrug.mobile.servlet;

import com.itrug.mobile.model.Order;
import com.itrug.mobile.service.OrderService;
import com.itrug.mobile.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/pay")
public class PayAction extends BaseAction {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService orderService=new OrderServiceImpl();
        int id=Integer.parseInt(request.getParameter("id"));
        Order order=((OrderServiceImpl) orderService).get(id);
        order.setPay(true);
        orderService.update(order);
        response.sendRedirect("orderList");
    }
}
