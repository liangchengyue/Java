package com.itrug.mobile.servlet;

import com.itrug.mobile.model.Mobile;
import com.itrug.mobile.service.MobileService;
import com.itrug.mobile.service.impl.MobileServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listMobile")
public class ListMobileAction extends BaseAction {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MobileService mobileService=new MobileServiceImp();
        List<Mobile> mobiles= mobileService.findAll();
        request.setAttribute("mobile",mobiles);
        request.getRequestDispatcher("mobile_list.jsp").forward(request,response);
    }
}
