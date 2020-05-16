package com.example.demo.controller;


import org.json.JSONArray;
import org.json.JSONObject;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class thread_create_json implements Callable<Map<String, ArrayList<Map<String, String>>>> {
    public volatile boolean flag = true;

    @Override
    public Map<String, ArrayList<Map<String, String>>> call() throws Exception {
        while (flag) {
            sleep(100);
            System.out.println("1秒运行一次");
            // 如果存在，就创建json文件
            if (resultAreThere("src/main/resources/algoresult")) {
                Map<String, ArrayList<Map<String, String>>> output = new HashMap<>();

                ArrayList<Map<String, String>> probabilityTable = new ArrayList<>();
                ArrayList<Map<String, String>> thresholdTable = new ArrayList<>();
                ArrayList<Map<String, String>> graphTable = new ArrayList<>();



                // create fileName json
                ArrayList<Map<String, String>> fileNameTable = new ArrayList<>();

                Map<String, String> fileNameMap = new HashMap<>();
                File file = new File("./unknown/");

                String[] filelist = file.list();
                if (filelist != null) {
                    fileNameMap.put("fileName", filelist[0]);
                    fileNameTable.add(fileNameMap);
                    output.put("fileNameTable", fileNameTable);
                }
                // create threshold json
                String thresholdStr = getJson("src/main/resources/algoresult/threshold.json");
                JSONObject thresholdJsonObject = new JSONObject(thresholdStr);
                Iterator thresholdKeys = thresholdJsonObject.keys();
                //然后通过循环遍历出的key值
                while (thresholdKeys.hasNext()) {
                    String thresholdKey = String.valueOf(thresholdKeys.next());
                    Map<String, String> thresholdDetail = new HashMap<>();
                    thresholdDetail.put("metricsName", thresholdKey);
                    thresholdDetail.put("threshold", String.valueOf(thresholdJsonObject.getFloat(thresholdKey)));
                    thresholdTable.add(thresholdDetail);
                }
                output.put("thresholdTable", thresholdTable);


                // create probability json and graph json
                String probabilityStr = getJson("src/main/resources/algoresult/probability.json");
                JSONObject probabilityJsonObject = new JSONObject(probabilityStr);
                Iterator keys = probabilityJsonObject.keys();
                //然后通过循环遍历出的key值
                while (keys.hasNext()) {
                    String key = String.valueOf(keys.next());
                    Map<String, String> probabilityDetail = new HashMap<>();
                    Map<String, String> graphDetail = new HashMap<>();
                    probabilityDetail.put("metricsName", key);
                    probabilityDetail.put("similarity", String.valueOf(probabilityJsonObject.getFloat(key)));

                    graphDetail.put("x", key);
                    graphDetail.put("y", String.valueOf(probabilityJsonObject.getFloat(key)));

                    probabilityTable.add(probabilityDetail);
                    graphTable.add(graphDetail);
                }
                output.put("probabilityTable", probabilityTable);
                output.put("graphTable", graphTable);


                flag = false;
                return output;

            }
        }

        return new HashMap<>();
    }


    public boolean resultAreThere(String filepath) throws FileNotFoundException, IOException {
        try {
            File file = new File(filepath);
            // 可能会有一个bug！！！！！！！！！！！！！！！！
            String[] filelist = file.list();

            assert filelist != null;
            return filelist.length != 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static String getJson(String path) {
        String jsonStr = "";
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (Exception e) {
            System.out.println(System.getProperty("user.dir"));
            System.out.println(e + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return null;
        }
    }
}
