package com.example.hoteldemo.servers;

import com.example.hoteldemo.pojo.Order;
import com.example.hoteldemo.pojo.Room;

import java.util.List;

public interface OrderServer {
    Boolean insertOrder(Order order);
}
