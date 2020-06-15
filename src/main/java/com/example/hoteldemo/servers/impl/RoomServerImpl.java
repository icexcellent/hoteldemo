package com.example.hoteldemo.servers.impl;

import com.example.hoteldemo.dao.ServerDao;
import com.example.hoteldemo.pojo.Room;
import com.example.hoteldemo.servers.RoomServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServerImpl implements RoomServer {
    @Autowired
    private ServerDao serverDao;
    @Override
    public List<Room> findRoomList() {
        List<Room> list= new ArrayList<Room>();
        try {
            list=serverDao.findRoomList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Room> findRoomAll(String[] strNo) {
        List<Room> list = new ArrayList<Room>();
        try {
            for (String no: strNo) {
                list.add(serverDao.findRoom(no));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int sumPrice(List<Room> list) {
        int sum=0;
        try {
            for (Room room:list) {
                sum+=Integer.parseInt(room.getJg());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sum;
    }

}
