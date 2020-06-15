package com.example.hoteldemo.servers;

import com.example.hoteldemo.pojo.Room;
import com.example.hoteldemo.pojo.User;

import java.util.List;

public interface UserServer {
    Boolean findUser(User user);
}
