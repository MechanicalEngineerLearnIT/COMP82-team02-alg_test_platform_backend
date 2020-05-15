package com.example.demo.controller;


import org.json.JSONArray;
import org.json.JSONObject;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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


                /*
                create AUG_graph json

                String graphStr = getJson("src/main/resources/algoresult/graph.json");
                JSONArray graphArr = new JSONArray(graphStr);
                for (int i = 0; i < graphArr.length(); i++) {
                    JSONObject graphJsonObj = graphArr.getJSONObject(i);
                    //grashjson graphDetail = new grashjson();
                    Map<String,String> graphDetail = new HashMap<>();

                    graphDetail.put("URL" , graphJsonObj.getString("URL"));
                    AUG_graph.add(graphDetail);
                }
                output.put("AUG_graph", AUG_graph);*/


                // create probability json
                String probabilityStr = getJson("src/main/resources/algoresult/probability.json");
                JSONArray probabilityArr = new JSONArray(probabilityStr);
                for (int i = 0; i < probabilityArr.length(); i++) {
                    JSONObject probabilityJsonObj = probabilityArr.getJSONObject(i);

                    Map<String, String> probabilityDetail = new HashMap<>();
                    //probabilityDetail.put("matrixName", probabilityJsonObj.getString("matrixName"));
                    probabilityDetail.put("probability", String.valueOf(probabilityJsonObj.getFloat("probability")));
                    probabilityTable.add(probabilityDetail);
                }
                output.put("probabilityTable", probabilityTable);

                ArrayList<Map<String, String>> fileNameTable = new ArrayList<>();

                Map<String, String> fileNameMap = new HashMap<>();
                File file = new File("./unknown/");

                String[] filelist = file.list();
                if (filelist != null) {
                    fileNameMap.put("fileName", filelist[0]);
                    fileNameTable.add(fileNameMap);
                    output.put("fileNameTable", fileNameTable);
                }





/*


                // create probability json
                String probabilityStr = getJson("src/main/resources/algoresult/probability.json");
                JSONArray probabilityArr = new JSONArray(probabilityStr);
                for (int i = 0; i < probabilityArr.length(); i++) {
                    JSONObject probabilityJsonObj = probabilityArr.getJSONObject(i);
                    JSONObject probabilityDetail = new JSONObject();
                    probabilityDetail.put("filename", probabilityJsonObj.getString("filename"));
                    probabilityDetail.put("correct", probabilityJsonObj.getInt("correct"));
                    probabilityDetail.put("predict", probabilityJsonObj.getInt("predict"));
                    probabilityDetail.put("probability", probabilityJsonObj.getFloat("probability"));
                    probabilityTable.put(probabilityDetail);
                }

                // create similarity json
                String similarityStr = getJson("src/main/resources/algoresult/similarity.json");
                JSONArray similarityArr = new JSONArray(probabilityStr);
                for (int i = 0; i < similarityArr.length(); i++) {
                    JSONObject similarityJsonObj = similarityArr.getJSONObject(i);
                    JSONObject similarityDetail = new JSONObject();
                    similarityDetail.put("filename", similarityJsonObj.getString("filename"));
                    similarityDetail.put("correct", similarityJsonObj.getInt("correct"));
                    similarityDetail.put("predict", similarityJsonObj.getInt("predict"));
                    similarityDetail.put("similarity", similarityJsonObj.getFloat("similarity"));
                    similarityTable.put(similarityDetail);
                }*/


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
