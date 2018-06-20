package com.itrug.mobile;

import com.itrug.mobile.model.Mobile;
import com.itrug.mobile.model.Order;
import com.itrug.mobile.model.User;
import com.itrug.mobile.service.MobileService;
import com.itrug.mobile.service.OrderService;
import com.itrug.mobile.service.UserService;
import com.itrug.mobile.service.impl.MobileServiceImp;
import com.itrug.mobile.service.impl.OrderServiceImpl;
import com.itrug.mobile.service.impl.UserServiceImp;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;

import java.util.Date;
import java.util.List;

/****
 * 手动测试各个服务是否生效
 */
public class Test {
    public static void main(String arg[]){

        //测试用户Service
//        UserService userService=new UserServiceImp();
//        User user=new User();
//        user.setId(8);
//        user.setUsername("zxx13");
//        user.setNickname("HHHHH10");
//        user.setSex(false);
//        user.setAge(20);
//        user.setAdmin(true);
//        user.setPassword("zxx1234567");
////        userService.delete(7);
//        int i=userService.findAll().size();
//        System.out.print(i);

        //测试手机Service
        MobileService mobileService=new MobileServiceImp();
//        Mobile mobile=new Mobile();
//        mobile.setName("华为");
//        mobile.setModel("青春版");
//        mobile.setImage("c:inga.jsp");
//        mobile.setPrice(1200);
//        mobile.setVendor("华为科技");

        //添加手机
//        mobileService.save(mobile);

        //修改手机
//        mobile.setId(1);
//        System.out.print(mobileService.update(mobile));

        //删除手机
//        mobileService.delete(3);

        //查找手机
//        System.out.print(mobileService.get(1));


        //获取所有的信息
//        System.out.print(mobileService.findAll().size());

        OrderService orderService=new OrderServiceImpl();
        Order order=new Order();
        order.setPrice(2000);
        order.setNumber(2);
        order.setPay(false);
        order.setUserId(1);
        order.setMobileId(1);
        order.setCrateTime(new Date());

        //添加订单
//        orderService.save(order);

//        修改
//        order.setId(2);
//        orderService.update(order);

        //删除
//        orderService.delete(2);

        //查询
//        System.out.print(orderService.get(3).getPrice());

        //获取所有的Order信息
//        System.out.print(orderService.findAll().size());

    }
}
