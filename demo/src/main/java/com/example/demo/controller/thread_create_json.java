package com.example.demo.controller;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class thread_create_json implements Callable<JSONObject> {
    public volatile boolean flag = true;

    @Override
    public JSONObject call() throws Exception {
        while (flag) {
            sleep(100);
            System.out.println("1秒运行一次");
            // 如果存在，就创建json文件
            if (resultAreThere("src/main/resources/algoresult")) {

                JSONArray AUG_graph = new JSONArray();
                JSONArray probabilityTable = new JSONArray();
                JSONArray resultTable = new JSONArray();
                JSONArray f1_scoreTable = new JSONArray();
                JSONArray similarityTable = new JSONArray();

                /*
                create AUG_graph json
                 */
                String graphStr = getJson("src/main/resources/algoresult/graph.json");
                JSONArray graphArr = new JSONArray(graphStr);
                for (int i = 0; i < graphArr.length(); i++) {
                    JSONObject graphJsonObj = graphArr.getJSONObject(i);
                    JSONObject graphDetail = new JSONObject();
                    graphDetail.put("URL", graphJsonObj.getString("URL"));
                    AUG_graph.put(graphDetail);
                }


                // create f1 json
                String f1Str = getJson("src/main/resources/algoresult/f1table.json");
                JSONArray f1Arr = new JSONArray(f1Str);
                for (int i = 0; i < f1Arr.length(); i++) {
                    JSONObject f1JsonObj = f1Arr.getJSONObject(i);
                    JSONObject f1Detail = new JSONObject();
                    f1Detail.put("matrixName", f1JsonObj.getString("matrixName"));
                    f1Detail.put("f1", f1JsonObj.getFloat("f1"));
                    f1_scoreTable.put(f1Detail);
                }


                // create result json
                String resultStr = getJson("src/main/resources/algoresult/resultTF.json");
                JSONArray resultArr = new JSONArray(resultStr);
                for (int i = 0; i < resultArr.length(); i++) {
                    JSONObject resultJsonObj = resultArr.getJSONObject(i);
                    JSONObject resultDetail = new JSONObject();
                    resultDetail.put("filename", resultJsonObj.getString("filename"));
                    resultDetail.put("correct", resultJsonObj.getInt("correct"));
                    resultDetail.put("predict", resultJsonObj.getInt("predict"));
                    resultDetail.put("result", resultJsonObj.getString("result"));

                    resultTable.put(resultDetail);
                }

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
                }


                JSONObject outData = new JSONObject();
                //把json数组加到json对象中
                //此时创建出来的如下:outData={"AUG_graph":[],"f1_scoreTable":[],"resultTable":[],"probabilityTable":[],"similarityTable":[]};
                outData.put("AUG_graph", AUG_graph);
                outData.put("f1_scoreTable", f1_scoreTable);
                outData.put("resultTable", resultTable);
                outData.put("probabilityTable", probabilityTable);
                outData.put("similarityTable", similarityTable);

                flag = false;
                return outData;

            }
        }
        JSONObject outData = new JSONObject();
        outData.put("fail_information","failed Calculation");
        return outData;
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
