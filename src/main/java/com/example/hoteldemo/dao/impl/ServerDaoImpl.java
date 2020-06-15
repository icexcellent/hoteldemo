package com.example.hoteldemo.dao.impl;

import com.example.hoteldemo.dao.ServerDao;
import com.example.hoteldemo.pojo.Order;
import com.example.hoteldemo.pojo.Room;
import com.example.hoteldemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * 持久层
 */
@Repository
public class ServerDaoImpl implements ServerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询tb_user表，返回User对象
     */
    @Override
    public User findUser(User user) {
        User u = new User();
        String sql = "Select * from tb_user where name=? and passwad=?";
        Object[] arr = new Object[]{user.getAccount(),user.getPassword()};
        jdbcTemplate.query(sql, arr, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                u.setAccount(resultSet.getString("name"));
                u.setPassword(resultSet.getString("passwad"));
            }
        });
        return u;
    }

    /**
     * 查询tb_room表所有信息，返回一个列表
     */
    @Override
    public List<Room> findRoomList() {
        String sql = "select * from tb_room";
        return jdbcTemplate.query(sql, new RowMapper<Room>() {
            @Override
            public Room mapRow(ResultSet resultSet, int i) throws SQLException {
                Room room = new Room();
                room.setName(resultSet.getString("name"));
                room.setNo(resultSet.getString("no"));
                room.setBreakfast(resultSet.getString("breakfast"));
                room.setBed(resultSet.getString("bed"));
                room.setNet(resultSet.getString("net"));
                room.setJg(resultSet.getString("jg"));
                return room;
            }
        });
    }

    /**
     * 查询tb_room表，返回Room对象
     */
    @Override
    public Room findRoom(String no) {
        Room room = new Room();
        String sql = "select * from tb_room where no=?";
        Object[] arr = new Object[]{no};
        jdbcTemplate.query(sql, arr, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                room.setName(resultSet.getString("name"));
                room.setNo(resultSet.getString("no"));
                room.setBreakfast(resultSet.getString("breakfast"));
                room.setBed(resultSet.getString("bed"));
                room.setNet(resultSet.getString("net"));
                room.setJg(resultSet.getString("jg"));
            }
        });
        return room;
    }
    /**
     * 在tb_order表进行添加
     */
    @Override
    public int insertOrder(Order order) {
        String sql = "insert into tb_order values(null,?,?,?,?,null)";
        int flag=jdbcTemplate.update(sql,order.getName(),order.getNumber(),order.getAddress(),order.getTotalPrice());
        return flag;
    }

}
