package com.itrug.mobile.servlet;

import com.itrug.mobile.model.User;
import com.itrug.mobile.service.UserService;
import com.itrug.mobile.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/updateUser")
public class UpdateUserAction extends  BaseAction {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserService userService=new UserServiceImp();
        int id=Integer.parseInt(request.getParameter("id"));
        User user=((UserServiceImp) userService).get(id);
        user.setNickname(request.getParameter("nickname"));
        user.setUsername(request.getParameter("username"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        if (request.getParameter("sex")=="男")
        {
            user.setSex(true);
        }else {
            user.setSex(false);
        }
        userService.update(user);
        response.sendRedirect("listUser");
    }
}
