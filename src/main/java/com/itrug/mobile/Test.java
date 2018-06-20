package com.itrug.mobile;

import com.itrug.mobile.model.User;
import com.itrug.mobile.service.UserService;
import com.itrug.mobile.service.impl.UserServiceImp;

public class Test {
    public static void main(String arg[]){
        UserService userService=new UserServiceImp();
        User user=  userService.get(1);
        System.out.print(user.getUsername());
    }
}
