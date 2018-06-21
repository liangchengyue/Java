package com.itrug.mobile.servlet;

import com.itrug.mobile.model.Mobile;
import com.itrug.mobile.service.MobileService;
import com.itrug.mobile.service.impl.MobileServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/deleteMobile")
public class DeleteMobileActive extends BaseAction {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id=Integer.parseInt(request.getParameter("id"));
        MobileService mobileService=new MobileServiceImp();
        mobileService.delete(id);
        response.sendRedirect("listMobile");
    }
}
