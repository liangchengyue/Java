package com.itrug.mobile.servlet;

import com.itrug.mobile.model.Mobile;
import com.itrug.mobile.service.MobileService;
import com.itrug.mobile.service.impl.MobileServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/findMobileById")
public class FindMobileById extends BaseAction  {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MobileService mobileService=new MobileServiceImp();
        Mobile mobile=((MobileServiceImp) mobileService).get(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("mobile",mobile);
        request.getRequestDispatcher("update_mobile.jsp").forward(request,response);
    }
}
