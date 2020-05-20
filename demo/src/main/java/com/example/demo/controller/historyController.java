package com.example.demo.controller;

import com.example.demo.model.history;
import com.example.demo.repository.historyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class historyController {

    @Autowired
    historyRepository historyRepo;

    @RequestMapping(value ="/getAllRecords", method = RequestMethod.POST)
    @ResponseBody
    public List<history> getAllRecords() {
        return historyRepo.getAllRecords();
    }

    @RequestMapping(value ="/getRecords", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Map<String, String>> getRecords(@RequestParam("userEmail") String userEmail) {
        ArrayList<Map<String, String>> history = historyRepo.getRecords(userEmail);

        if (history.size() >= 1) {
            return history;

        } else {
            ArrayList<Map<String, String>> emptyHistory = new ArrayList<>();
            Map<String, String> emptyError = new HashMap<>();

            emptyError.put("fileName", "null");
            emptyError.put("submissionTime", "null");
            emptyError.put("result", "null");
            emptyError.put("threshold", "null");

            emptyHistory.add(emptyError);
            return emptyHistory;
        }

    }

    /*
    used to delete user's history
    if user want to delete
     */
    @RequestMapping(value ="/deleteRecord", method = RequestMethod.POST)
    @ResponseBody
    public String deteteRecord(@RequestParam("userEmail") String userEmail, @RequestParam("submissionTime") Timestamp submissionTime) {
        if (historyRepo.deleteRecord(userEmail, submissionTime) >= 1) {
            return "User Deleted Successfully";
        } else {
            return "Something went wrong !";
        }
    }
}
