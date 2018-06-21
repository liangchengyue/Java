package com.itrug.mobile.servlet;

import com.itrug.mobile.service.OrderService;
import com.itrug.mobile.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/deleteOrder")
public class DeleteOrderActive extends BaseAction {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        OrderService orderService=new OrderServiceImpl();
        orderService.delete(id);
        response.sendRedirect("orderListManager");
    }
}
