package com.example.demo.repository;


import com.example.demo.model.userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class userinfoRepository {

    @Autowired
    JdbcTemplate template;

    /*Getting all users from table*/
    public List<userinfo> getAllItems(){
        List<userinfo> items = template.query("select userEmail,userPassword from userinfo",(result,rowNum)->new userinfo(
                result.getString("userEmail"),result.getString("userPassword")));
        return items;
    }
    /*Getting a specific user by userEmail from table*/
    public userinfo getItem(String userEmail){
        String query = "SELECT * FROM userinfo WHERE userEmail =?";
        userinfo item = template.queryForObject(query,new Object[]{userEmail},new BeanPropertyRowMapper<>(userinfo.class));
        return item;
    }
    /*Adding a user into database table*/
    public int addItem(String userEmail,String userPassword){
        String query = "INSERT INTO userinfo VALUES(?,?)";
        return template.update(query,userEmail,userPassword);
    }
    /*delete a user from database*/
    public int deleteItem(String userEmail){
        String query = "DELETE FROM userinfo WHERE userEmail =?";
        return template.update(query,userEmail);
    }
}
