package com.example.demo.repository;

import com.example.demo.model.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository

public class historyRepository {
    @Autowired
    JdbcTemplate template;

    /*Getting all Items from table*/
    public List<history> getAllRecords(){
        List<history> items = template.query("select userEmail,submissionTime,possibility,fileName from history",(result,rowNum)->new history(
                result.getString("userEmail"),result.getTimestamp("submissionTime"),
                result.getString("possibility"),result.getString("fileName")));
        return items;
    }
    /*Getting all the previous records of one user by userEmail from table*/
    public history getRecords(String userEmail){
        String query = "SELECT * FROM history WHERE userEmail =?";
        history item = template.queryForObject(query,new Object[]{userEmail},new BeanPropertyRowMapper<>(history.class));
        return item;
    }
    /*Adding a record into database table*/
    public int addRecord(String userEmail, Timestamp submissionTime, String possibility, String fileName){
        String query = "INSERT INTO history VALUES(?,?,?,?)";
        return template.update(query,userEmail,submissionTime,possibility,fileName);
    }
    /*delete a record from database*/
    public int deleteRecord(String userEmail, Timestamp submissionTime){
        String query = "DELETE FROM history WHERE userEmail =? AND submissionTime =?";
        return template.update(query,userEmail,submissionTime);
    }
}
