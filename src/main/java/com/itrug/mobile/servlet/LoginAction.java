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
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        if (request.getParameter("isAdmin")=="true"){
            user.setAdmin(true);
        }else {
            user.setAdmin(false);
        }
        UserService userService=new UserServiceImp();
        user=userService.login(user);
        if (user!=null){
            request.getSession().setAttribute("user",user);
        }

    }
}
