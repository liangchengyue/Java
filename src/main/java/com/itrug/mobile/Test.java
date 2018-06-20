package com.itrug.mobile;

import com.itrug.mobile.model.User;
import com.itrug.mobile.service.UserService;
import com.itrug.mobile.service.impl.UserServiceImp;

import java.util.List;

public class Test {
    public static void main(String arg[]){
        UserService userService=new UserServiceImp();
//        User user=new User();
//        user.setUsername("zxx12");
//        user.setNickName("幸福摩天轮");
//        user.setSex(false);
//        user.setAge(20);
//        user.setAdmin(true);
//        user.setPassword("zxx123456");
        userService.delete(7);
        System.out.print("");
    }
}
