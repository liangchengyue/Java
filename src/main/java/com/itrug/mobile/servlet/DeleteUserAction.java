package com.itrug.mobile.servlet;

import com.itrug.mobile.service.UserService;
import com.itrug.mobile.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/deleteUser")
public class DeleteUserAction extends BaseAction {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserServiceImp();
        int id=Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        response.sendRedirect("listUser");
    }
}
