package com.itrug.mobile.servlet;

import com.itrug.mobile.model.User;
import com.itrug.mobile.service.UserService;
import com.itrug.mobile.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/login")
public class LoginAction extends BaseAction {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        boolean isAdmin=request.getParameter("isAdmin").trim()=="管理员";
        if (isAdmin){
            user.setAdmin(true);
        }else {
            user.setAdmin(false);
        }
        UserService userService=new UserServiceImp();
        User user1=userService.login(user);
        if (user1.getUsername()!=null&&user1.getUsername()!=""){
            request.getSession().setAttribute("user",user1);
            if (user1.isAdmin())
            {
                response.sendRedirect("manager.jsp");
            }else {
                response.sendRedirect("modileIndex");
            }
        }else {
            response.sendRedirect("login.jsp");
        }
    }
}
