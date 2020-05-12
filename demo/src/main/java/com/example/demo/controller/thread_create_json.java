package com.example.demo.controller;


import org.json.JSONArray;
import org.json.JSONObject;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class thread_create_json implements Callable<Map<String, ArrayList< Map<String, String>>>> {
    public volatile boolean flag = true;

    @Override
    public Map<String, ArrayList< Map<String, String>>> call() throws Exception {
        while (flag) {
            sleep(100);
            System.out.println("1秒运行一次");
            // 如果存在，就创建json文件
            if (resultAreThere("src/main/resources/algoresult")) {
                Map<String, ArrayList< Map<String, String>>> output = new HashMap<>();

                ArrayList< Map<String, String>> AUG_graph = new ArrayList<>();
                JSONArray probabilityTable = new JSONArray();
                ArrayList< Map<String, String>> resultTable = new ArrayList<>();
                ArrayList< Map<String, String>> f1_scoreTable = new ArrayList<>();
                JSONArray similarityTable = new JSONArray();

                /*
                create AUG_graph json
                 */
                String graphStr = getJson("src/main/resources/algoresult/graph.json");
                JSONArray graphArr = new JSONArray(graphStr);
                for (int i = 0; i < graphArr.length(); i++) {
                    JSONObject graphJsonObj = graphArr.getJSONObject(i);
                    //grashjson graphDetail = new grashjson();
                    Map<String,String> graphDetail = new HashMap<>();

                    graphDetail.put("URL" , graphJsonObj.getString("URL"));
                    AUG_graph.add(graphDetail);
                }
                output.put("AUG_graph", AUG_graph);


                // create f1 json
                String f1Str = getJson("src/main/resources/algoresult/f1table.json");
                JSONArray f1Arr = new JSONArray(f1Str);
                for (int i = 0; i < f1Arr.length(); i++) {
                    JSONObject f1JsonObj = f1Arr.getJSONObject(i);
                    //f1json f1Detail = new f1json();
                    Map<String,String> f1Detail = new HashMap<>();
                    f1Detail.put("matrixName" ,f1JsonObj.getString("matrixName"));
                    f1Detail.put("f1", String.valueOf(f1JsonObj.getFloat("f1")));
                    f1_scoreTable.add(f1Detail);
                }
                output.put("f1_scoreTable", f1_scoreTable);


                // create result json
                String resultStr = getJson("src/main/resources/algoresult/resultTF.json");
                JSONArray resultArr = new JSONArray(resultStr);
                for (int i = 0; i < resultArr.length(); i++) {
                    JSONObject resultJsonObj = resultArr.getJSONObject(i);
                    //resultjson resultDetail = new resultjson();
                    Map<String,String> resultDetail = new HashMap<>();
                    resultDetail.put("matrixName", resultJsonObj.getString("matrixName"));
                    resultDetail.put("question", resultJsonObj.getString("question"));
                    resultDetail.put("File", resultJsonObj.getString("File"));
                    resultDetail.put("Truth", String.valueOf(resultJsonObj.getInt("Truth")));
                    resultDetail.put("Prediction", String.valueOf(resultJsonObj.getInt("Prediction")));
                    resultDetail.put("result", resultJsonObj.getString("result"));

                    resultTable.add(resultDetail);
                }
                output.put("resultTable", resultTable);
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
