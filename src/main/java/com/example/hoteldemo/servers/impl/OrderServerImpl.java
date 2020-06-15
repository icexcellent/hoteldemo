package com.example.hoteldemo.servers.impl;

import com.example.hoteldemo.dao.ServerDao;
import com.example.hoteldemo.pojo.Order;
import com.example.hoteldemo.pojo.Room;
import com.example.hoteldemo.servers.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务层
 */
@Service
public class OrderServerImpl implements OrderServer {
    @Autowired
    private ServerDao serverDao;
    @Override
    public Boolean insertOrder(Order order) {
        Boolean bool = false;
        try {
            if(serverDao.insertOrder(order)>0){
                bool = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return bool;
    }
}
