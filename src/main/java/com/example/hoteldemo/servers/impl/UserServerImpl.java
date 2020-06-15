package com.example.hoteldemo.servers.impl;

import com.example.hoteldemo.dao.ServerDao;
import com.example.hoteldemo.pojo.User;
import com.example.hoteldemo.servers.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServerImpl implements UserServer {
    @Autowired
    private ServerDao userServerDao;
    @Override
    public Boolean findUser(User user) {
        Boolean bool = false;
        try{
            User u = userServerDao.findUser(user);
            if (u.getAccount()!=null&&u.getPassword()!=null) {
                bool = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return bool;
    }

}
