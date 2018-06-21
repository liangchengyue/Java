package com.itrug.mobile.servlet;

import com.itrug.mobile.model.Mobile;
import com.itrug.mobile.model.Order;
import com.itrug.mobile.model.User;
import com.itrug.mobile.service.MobileService;
import com.itrug.mobile.service.OrderService;
import com.itrug.mobile.service.impl.MobileServiceImp;
import com.itrug.mobile.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/orderList")
public class OrderListActive extends BaseAction {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User) request.getSession().getAttribute("user");
        OrderService orderService=new OrderServiceImpl();
        List<Order> orders=orderService.findOrderByUserId(user.getId());
        MobileService mobileService=new MobileServiceImp();
        List<Mobile> mobiles=mobileService.findAll();
        for (Order item:orders
             ) {
            for (Mobile m:mobiles
                 ) {
                if (item.getMobileId()==m.getId()){
                    item.setMobile(m);
                }
            }
        }
        request.setAttribute("order",orders);
        request.getRequestDispatcher("order_list.jsp").forward(request,response);
    }
}
