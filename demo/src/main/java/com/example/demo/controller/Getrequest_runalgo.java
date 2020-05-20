package com.example.demo.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import com.example.demo.model.history;
import com.example.demo.repository.historyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(value = "http://localhost:8080", maxAge = 3600)
public class Getrequest_runalgo {
    @Autowired
    historyRepository historyRepo;

    @RequestMapping(value="/runalgo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, ArrayList<Map<String, String>>> tableinfo(@RequestParam(value="userEmail") String userEmail,@RequestParam(value="n") String n) throws ExecutionException, InterruptedException {

        //todo run the algo

        try {
            System.out.println("running algorithm");
            Process p = Runtime.getRuntime().exec("python -m algo_script "+n);
            int re = p.waitFor();
            if (re == 0) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        // get timeStamp
        Timestamp time = new Timestamp(System.currentTimeMillis());
        java.sql.Timestamp submissionTime = to_sqldate(time.toString());

        // run algo with thread
        FutureTask<Map<String, ArrayList<Map<String, String>>>> futureTask = new FutureTask<>(new thread_create_json());
        Thread thread = new Thread(futureTask);
        thread.start();

        // get result from thread
        Map<String, ArrayList<Map<String, String>>> resultAlgo = futureTask.get();

        // get fileName for update database
        String fileName = resultAlgo.get("fileNameTable").get(0).get("fileName");

        //get result for update database
        ArrayList<Map<String, String>> resultTable = resultAlgo.get("probabilityTable");
        StringBuilder a = new StringBuilder();
        for(int i=0;i<resultTable.size();i++){
            String similarity = resultTable.get(i).get("similarity");
            String metricsName=resultTable.get(i).get("metricsName");
            String temp = metricsName +": "+similarity;
            a.append(temp).append(";");

        }
        String result = a.toString();


        //get threshold for update database
        ArrayList<Map<String, String>> thresholdTable = resultAlgo.get("thresholdTable");
        String threshold = thresholdTable.toString();

        System.out.println(n+"n");
        System.out.println(userEmail+"userEmail");
        System.out.println(fileName+"fileName");
        System.out.println(submissionTime+"submissionTime");
        System.out.println(result+"result");
        System.out.println(threshold+"threshold");

        //adding history into database
        if (historyRepo.addRecord(userEmail, fileName,submissionTime,result,threshold ) >= 1) {
            System.out.println("Record Added Successfully");
        } else {
            System.out.println("System wrong!");
        }
        // send jsonobeject to fronted
        System.out.println(resultAlgo);
        return resultAlgo;
    }

    // String --> Date时间
    public static java.sql.Timestamp to_sqldate(String time_date) {
        SimpleDateFormat sdf = null;
        final String GSTIME = "yyyy-MM-dd HH:mm:ss";
        sdf = new SimpleDateFormat(GSTIME);

        sdf.setTimeZone(TimeZone.getTimeZone("UTC")); // 就是这一步指定对应的时区
        Date date = null; //初始化date
        try {
            date = sdf.parse(time_date); //Mon Jan 14 00:00:00 CST 2013
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;

        return new Timestamp(date.getTime());

    }
}







