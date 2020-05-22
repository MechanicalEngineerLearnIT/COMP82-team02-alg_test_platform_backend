package com.example.demo.repository;

import com.example.demo.model.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class historyRepository {
    @Autowired
    JdbcTemplate template;

    /*Getting all Items from table*/
    public List<history> getAllRecords() {
        List<history> items = template.query("select userEmail,fileName,submissionTime,result,threshold,n_gram, conclusion from history", (result, rowNum) -> new history(
                result.getString("userEmail"), result.getTimestamp("submissionTime"),
                result.getString("result"), result.getString("threshold"),result.getString("fileName"),
                result.getString("n_gram"),result.getString("conclusion")));
        return items;
    }

    /*Getting all the previous records of one user by userEmail from table*/
    public ArrayList<Map<String, String>> getRecords(String userEmail) {
        String query = "SELECT * FROM history WHERE userEmail =?";
        List<history> item = template.query(query, new Object[]{userEmail}, new BeanPropertyRowMapper<>(history.class));

        ArrayList<Map<String, String>> userHistory = new ArrayList<>();

        for (int i = 0; i < item.size(); i++) {
            Map<String, String> eachHistory = new HashMap<>();
            eachHistory.put("fileName", item.get(i).getFileName());
            eachHistory.put("submissionTime", item.get(i).getSubmissionTime());
            eachHistory.put("possibility", item.get(i).getResult());
            eachHistory.put("threshold", item.get(i).getThreshold());
            eachHistory.put("n_gram", item.get(i).getN_gram());
            eachHistory.put("conclusion", item.get(i).getConclusion());
            userHistory.add(eachHistory);
        }


        return userHistory;
    }

    /*Adding a record into database table*/
    public int addRecord(String userEmail, String fileName, Timestamp submissionTime, String result,String threshold,String n_gram, String conclusion) {
        String query = "INSERT INTO history VALUES(?,?,?,?,?,?,?)";
        return template.update(query, userEmail, fileName,submissionTime, result,threshold,n_gram,conclusion);
    }

    /*delete a record from database if user want to delete history*/
    public int deleteRecord(String userEmail, String fileName, Timestamp submissionTime, String result,String threshold,String n_gram, String conclusion) {
        String query = "DELETE FROM history WHERE userEmail =? AND submissionTime =?";
        return template.update(query, userEmail, fileName,submissionTime, result,threshold,n_gram,conclusion);
    }
}
