package com.itrug.mobile;

import com.itrug.mobile.model.User;
import com.itrug.mobile.service.UserService;
import com.itrug.mobile.service.impl.UserServiceImp;

import java.util.List;

public class Test {
    public static void main(String arg[]){
        UserService userService=new UserServiceImp();
        User user=new User();
        user.setId(8);
        user.setUsername("zxx13");
        user.setNickname("HHHHH10");
        user.setSex(false);
        user.setAge(20);
        user.setAdmin(true);
        user.setPassword("zxx1234567");
//        userService.delete(7);
        int i=userService.findAll().size();
        System.out.print(i);
    }
}
