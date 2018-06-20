package com.itrug.mobile.servlet;

import com.itrug.mobile.model.User;
import com.itrug.mobile.service.UserService;
import com.itrug.mobile.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/addUser")
public class AddUserAction extends BaseAction {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("----------------------");
        User user=new User();
        user.setNickname(request.getParameter("nickname"));
        user.setPassword(request.getParameter("password"));
        user.setUsername(request.getParameter("username"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        if (request.getParameter("sex")=="男")
        {
            user.setSex(true);
        }else {
            user.setSex(false);
        }
        UserService userService=new UserServiceImp();
        userService.save(user);

    }
}
