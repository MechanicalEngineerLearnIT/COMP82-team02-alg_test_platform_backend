package com.example.demo.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@RestController
@RequestMapping("/selectmode")
@CrossOrigin(value = "http://localhost:8080", maxAge = 3600)
public class Getrequest_runalgo {

    @RequestMapping("/runalgo")
    @ResponseBody
    public Map<String, ArrayList< Map<String, String>>> tableinfo() throws ExecutionException, InterruptedException {
        //todo run the algo
        /*
        try {
            System.out.println("running algorithm under mode " + message);
            Process p = Runtime.getRuntime().exec("python -m fake_algo");
            int re = p.waitFor();
            if (re == 0) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
            System.out.println(e);
        }*/

        System.out.println("getting result");

        FutureTask<Map<String, ArrayList<Map<String, String>>>> futureTask = new FutureTask<>(new thread_create_json());
        Thread thread = new Thread(futureTask);
        thread.start();

        // send jsonobeject to fronted
        return futureTask.get();
    }


}





