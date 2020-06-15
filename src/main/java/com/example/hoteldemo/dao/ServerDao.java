package com.example.hoteldemo.dao;


import com.example.hoteldemo.pojo.Order;
import com.example.hoteldemo.pojo.Room;
import com.example.hoteldemo.pojo.User;

import java.util.List;

/**
 * 创建接口
 */
public interface ServerDao {
    /**
     * 创建抽象方法用来查询
     * @param user
     * @return User
     */
    User findUser(User user);

    /**
     * 创建抽象方法用来查询
     * @return List<Room>
     */
    List<Room> findRoomList();

    /**
     * 创建抽象方法用来查询
     * @param no
     * @return Room
     */
    Room findRoom(String no);

    /**
     * 创建抽象方法用来添加
     * @param order
     * @return int
     */
    int insertOrder(Order order);
}
