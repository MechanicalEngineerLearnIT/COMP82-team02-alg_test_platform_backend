package com.example.demo.controller;

import com.example.demo.model.history;
import com.example.demo.repository.historyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
public class historyController {

    @Autowired
    historyRepository historyRepo;

    @RequestMapping("/getAllRecords")
    @ResponseBody
    public List<history> getAllRecords(){ return historyRepo.getAllRecords(); }

    @RequestMapping("/getRecords")
    @ResponseBody
    public history getRecords(@RequestParam("userEmail") String userEmail){ return historyRepo.getRecords(userEmail); }


    @RequestMapping("/addRecord")
    @ResponseBody
    public String addRecord(@RequestParam("userEmail") String userEmail,@RequestParam("submissionTime") Timestamp submissionTime,
                            @RequestParam("possibility") String possibility,@RequestParam("fileName") String fileName
    ){
        if(historyRepo.addRecord(userEmail,submissionTime,possibility,fileName) >= 1){
            return "Record Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
    @RequestMapping("/deteRecord")
    @ResponseBody
    public String deteteRecord(@RequestParam("userEmail") String userEmail,@RequestParam("submissionTime") Timestamp submissionTime){
        if(historyRepo.deleteRecord(userEmail,submissionTime) >= 1){
            return "User Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}
