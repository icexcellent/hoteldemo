package com.example.hoteldemo.controller;

import com.example.hoteldemo.pojo.Order;
import com.example.hoteldemo.pojo.Room;
import com.example.hoteldemo.pojo.User;
import com.example.hoteldemo.servers.OrderServer;
import com.example.hoteldemo.servers.RoomServer;
import com.example.hoteldemo.servers.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/proc")
public class ProcessingReqController {
    @Autowired
    private OrderServer orderServer;
    @Autowired
    private UserServer userServer;
    @Autowired
    private RoomServer roomServer;
    @PostMapping("/login")
    public String login(User user,HttpServletRequest req){
           Boolean bool = userServer.findUser(user);
           if(bool){
               req.getSession().setAttribute("user",user);
               return "success";
           }
           else return "fail";
    }

    @GetMapping("/showlist")
    public String showlist(ModelMap map,HttpServletRequest req){
            if(req.getSession().getAttribute("user")!=null){
                map.addAttribute("roomlist",roomServer.findRoomList());
                return "roomlist";
            }
            else return "fail";
    }

    @RequestMapping("/order")
    public String order(HttpServletRequest req,ModelMap map){
        String[] strNo = req.getParameterValues("selectedrooms");
        List<Room> list = new ArrayList<Room>();
        list=roomServer.findRoomAll(strNo);
        map.addAttribute("roomlist",list);
        req.getSession().setAttribute("sumPrice",roomServer.sumPrice(list));
        return "order";
    }

    @RequestMapping("/showMessage")
    public String showMessage(HttpServletRequest req, ModelMap map, Order order){
            order.setTotalPrice((Integer) req.getSession().getAttribute("sumPrice"));
            if(orderServer.insertOrder(order)){
                map.addAttribute("order",order);
                return "message";
            }
            else return "fail";

    }
}
