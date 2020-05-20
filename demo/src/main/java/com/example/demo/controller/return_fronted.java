package com.example.demo.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


@Controller
public class return_fronted {
    @RequestMapping("/result")
    @ResponseBody
    public Map<String, ArrayList< Map<String, String>>> sendToFronted() throws ExecutionException, InterruptedException {
        System.out.println("getting result");

        FutureTask<Map<String, ArrayList< Map<String, String>>>> futureTask = new FutureTask<>(new thread_create_json());
        Thread thread = new Thread(futureTask);
        thread.start();

        // send jsonobeject to fronted
        return futureTask.get();

    }

}
