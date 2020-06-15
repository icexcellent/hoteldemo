package com.example.hoteldemo.servers;

import com.example.hoteldemo.pojo.Room;

import java.util.List;

public interface RoomServer {
    List<Room> findRoomList();
    List<Room> findRoomAll(String[] strNo);
    int sumPrice(List<Room> list);
}
